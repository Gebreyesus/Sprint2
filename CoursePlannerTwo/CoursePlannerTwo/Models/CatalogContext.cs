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
        public int id { get; set; }
        public int courseNumber { get; set; }
        public string title { get; set; }
        public string titleShort { get; set; }
        public string description { get; set; }
        public List<Course> prereqs;

      
    }
}
