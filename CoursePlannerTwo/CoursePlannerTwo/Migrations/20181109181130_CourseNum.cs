using Microsoft.EntityFrameworkCore.Migrations;

namespace CoursePlannerTwo.Migrations
{
    public partial class CourseNum : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<string>(
                name: "courseNum",
                table: "courses",
                nullable: true,
                oldClrType: typeof(int));
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<int>(
                name: "courseNum",
                table: "courses",
                nullable: false,
                oldClrType: typeof(string),
                oldNullable: true);
        }
    }
}
