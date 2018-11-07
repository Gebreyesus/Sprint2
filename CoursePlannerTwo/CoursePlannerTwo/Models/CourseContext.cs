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
        public string name { get; set; }
        public int credits { get; set; }
        public string prereqs { get; set; }
        public int courseNum { get; set; }
        public string offeredIn { get; set; }
        public string description { get; set; }
        public string department { get; set; }

    }
}
