﻿// <auto-generated />
using CoursePlannerTwo.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;

namespace CoursePlannerTwo.Migrations
{
    [DbContext(typeof(CatalogContext))]
    [Migration("20181107202014_Prereqs")]
    partial class Prereqs
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "2.1.3-rtm-32065")
                .HasAnnotation("Relational:MaxIdentifierLength", 128)
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("CoursePlannerTwo.Models.Course", b =>
                {
                    b.Property<int>("id")
                        .ValueGeneratedOnAdd()
                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                    b.Property<int>("courseNumber");

                    b.Property<string>("description");

                    b.Property<string>("prereqs");

                    b.Property<string>("title");

                    b.Property<string>("titleShort");

                    b.HasKey("id");

                    b.ToTable("courses");
                });
#pragma warning restore 612, 618
        }
    }
}
