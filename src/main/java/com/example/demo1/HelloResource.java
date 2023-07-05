package com.example.demo1;

import com.example.demo1.entity.Taches;
import javafx.concurrent.Task;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/taches")
public class HelloResource {
    static List<Taches> tasks= new ArrayList<Taches>();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {

        return  Response.status(200).entity(tasks).build();
        //return "Hello, World!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response addTask(Taches task){
        if (tasks.add(task))
            return  Response.status(201).entity(tasks).build();
        return  Response.status(404 ).entity(tasks).build();

    }
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/modification/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)

    public Response affectTaskToEmployee(Taches task,@PathParam("id") String id){
        List<Taches> found= new ArrayList<Taches>();
        boolean isChanged=false;
        for(Taches t : tasks){
            if (t.getId().equals(id)){
                t.setIdEmp(task.getIdEmp());
                isChanged=true;
            }
        }
        if (!isChanged)
            return Response.status(404).entity("NOT FOUND").build();
        return Response.status(200).entity("Tache affectee avec succes").build();

    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("supprimer")
    public Response deleteTask(@QueryParam("ref")String id){
        boolean taskRemoved=false;
        Taches t= new Taches();
        t.setId(id);
        while (tasks.remove(t))
         taskRemoved=true;
        if(taskRemoved)
            return Response.status(200).entity(tasks).build();
        return Response.status(404).entity("NOT FOUND").build();

    }

}