using Microsoft.EntityFrameworkCore.Migrations;

namespace CoursePlannerTwo.Migrations
{
    public partial class Match : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "titleShort",
                table: "courses",
                newName: "offeredIn");

            migrationBuilder.RenameColumn(
                name: "title",
                table: "courses",
                newName: "name");

            migrationBuilder.RenameColumn(
                name: "courseNumber",
                table: "courses",
                newName: "credits");

            migrationBuilder.AddColumn<int>(
                name: "courseNum",
                table: "courses",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.AddColumn<string>(
                name: "department",
                table: "courses",
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "courseNum",
                table: "courses");

            migrationBuilder.DropColumn(
                name: "department",
                table: "courses");

            migrationBuilder.RenameColumn(
                name: "offeredIn",
                table: "courses",
                newName: "titleShort");

            migrationBuilder.RenameColumn(
                name: "name",
                table: "courses",
                newName: "title");

            migrationBuilder.RenameColumn(
                name: "credits",
                table: "courses",
                newName: "courseNumber");
        }
    }
}
