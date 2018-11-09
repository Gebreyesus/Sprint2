using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using CsvHelper;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;

namespace CoursePlannerTwo.Models
{
    public static class SeedData
    {
        public static void Initialize(IServiceProvider serviceProvider)
        {
            using (var context = new CatalogContext(serviceProvider.GetRequiredService<DbContextOptions<CatalogContext>>()))
            {
                if (context.courses.Any())
                {
                    return; // db has been seeded
                }
                var bad = new List<string>();
                TextReader reader = new StreamReader("coursecatalog.csv");
                CsvReader csv = new CsvReader(reader,true);

                csv.Configuration.BadDataFound = con =>
                {
                    bad.Add(con.RawRecord);
                };
                var record = csv.GetRecords<Course>().ToList();
                context.courses.AddRange(record);
                Console.WriteLine(csv.ToString());
                context.SaveChanges();
            }
        }
    }
}
