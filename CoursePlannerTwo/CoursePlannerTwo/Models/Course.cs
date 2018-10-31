using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CoursePlannerTwo.Models
{
    public class Course
    {
        public int id { get; set; }
        public int courseNumber { get; set; }
        public string title { get; set; }
        public string titleShort { get; set; }
        public string description { get; set; }
        public List<Course> prereqs;

        public Course(int id, int courseNumber, string title, string titleShort, string description, List<Course> prereqs)
                {
                    this.id = id;
                    this.courseNumber = courseNumber;
                    this.title = title;
                    this.titleShort = titleShort;
                    this.description = description;
                    this.prereqs = prereqs;
                }
    }
}
