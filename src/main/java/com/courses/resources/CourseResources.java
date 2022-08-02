package com.courses.resources;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;

import com.courses.Course;
import com.courses.dao.CourseDAO;

@Path("/courses")
public class CourseResources {
    private CourseDAO courseDAO = new CourseDAO();

    // list all courses
    @GET
    @Produces("application/json")
    public void listCourses() {
        courseDAO.listCourses();
    }

    // create course
    @POST
    @Produces("application/json")
    public void createCourse(Course course) throws Exception {
        courseDAO.createCourse(course);
    }

    // get course
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Course getCourse(int id) throws Exception {
        return courseDAO.getCourse(id);
    }

    // update course
    @PUT
    @Path("/{id}")
    @Produces("application/json")
    public void updateCourse(Course course) throws Exception {
        courseDAO.updateCourse(course);
    }

    // delete course
    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public void deleteCourse(int id) throws Exception {
        courseDAO.deleteCourse(id);
    }
    
}
