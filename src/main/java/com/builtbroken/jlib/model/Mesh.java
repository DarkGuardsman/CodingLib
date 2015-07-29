package com.builtbroken.jlib.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dark on 6/10/2015.
 */
public class Mesh implements Cloneable
{
    public final List<Vert> vertices = new ArrayList();
    public final List<UVPoint> textureCoordinates = new ArrayList();
    public final List<Vert> normals = new ArrayList();
    public final List<Face> faces = new ArrayList();

    public void addVert(Vert pos)
    {
        this.vertices.add(pos);
    }

    public List<Vert> getVertices() {
        return vertices;
    }

    public List<Face> getFaces() {
        return faces;
    }

    @Override
    public Mesh clone()
    {
        Mesh mesh = new Mesh();
        mesh.vertices.addAll(vertices);
        mesh.textureCoordinates.addAll(textureCoordinates);
        mesh.normals.addAll(normals);
        for(Face face : faces)
            mesh.faces.add(face.clone());
        return mesh;
    }
}
