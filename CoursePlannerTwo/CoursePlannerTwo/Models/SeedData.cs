using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
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

            }
        }
    }
}
