package com.builtbroken.jlib.helpers;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**@deprecated Removing as I see no point in including this in a common library when other libraries exist for the same purpose */
@Deprecated
public class HTTPHelper
{
    public static String executePost(String targetURL, HashMap<String, String> data)
    {
        String string = "";
        Iterator<Map.Entry<String, String>> set = data.entrySet().iterator();
        while (set.hasNext())
        {
            Map.Entry<String, String> entry = set.next();
            string += entry.getKey() + "=" + entry.getValue();
            if (set.hasNext())
            {
                string += "&";
            }
        }
        return executePost(targetURL, string);
    }

    public static String executePost(String targetURL, String urlParameters)
    {
        System.out.println("Sending data " + urlParameters + " to " + targetURL);
        HttpURLConnection connection = null;

        try
        {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            OutputStream os = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(urlParameters);
            writer.flush();
            writer.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null)
            {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        }
        catch (Exception e)
        {
            //TODO check if client wants error when failing to report data
            e.printStackTrace();
            return null;
        }
        finally
        {
            if (connection != null)
            {
                connection.disconnect();
            }
        }
    }

    public static String executeGet(final String targetURL)
    {
        System.out.println("Sending get call to " + targetURL);
        HttpURLConnection connection = null;

        try
        {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null)
            {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        }
        catch (Exception e)
        {
            //TODO check if client wants error when failing to report data
            e.printStackTrace();
            return null;
        }
        finally
        {
            if (connection != null)
            {
                connection.disconnect();
            }
        }
    }
}
