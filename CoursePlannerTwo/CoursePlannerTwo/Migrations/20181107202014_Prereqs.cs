using Microsoft.EntityFrameworkCore.Migrations;

namespace CoursePlannerTwo.Migrations
{
    public partial class Prereqs : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "prereqs",
                table: "courses",
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "prereqs",
                table: "courses");
        }
    }
}
