using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;

namespace CoursePlannerTwo.Models
{
    public class CatalogContext : DbContext
    {

        public CatalogContext(DbContextOptions<CatalogContext> options) : base(options)
        {

        }

        public DbSet<Course> courses { get; set; }
    }

    public class Course
    {
        public int ID { get; set; }
        public string courseNum { get; set; }
        public int credits { get; set; }
        public string name { get; set; }
        public string prereqs { get; set; }
        public string offeredIn { get; set; }
        public string description { get; set; }
        public string department { get; set; }
     

    }

    public class User
    {   
        public string fullName { get; set; }
        public int year { get; set; }
        public int studentId { get; set; }
        public Transcript transcript { get; set; }

    }

    public class Transcript
    {   
        public int studentId { get; set; }
        public List<Course> courses { get; set; }
    }
}
