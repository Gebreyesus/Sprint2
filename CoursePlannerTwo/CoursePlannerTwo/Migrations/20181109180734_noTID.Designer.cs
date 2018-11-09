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
    [Migration("20181109180734_noTID")]
    partial class noTID
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

                    b.Property<int>("courseNum");

                    b.Property<int>("credits");

                    b.Property<string>("department");

                    b.Property<string>("description");

                    b.Property<string>("name");

                    b.Property<string>("offeredIn");

                    b.Property<string>("prereqs");

                    b.HasKey("id");

                    b.ToTable("courses");
                });
#pragma warning restore 612, 618
        }
    }
}