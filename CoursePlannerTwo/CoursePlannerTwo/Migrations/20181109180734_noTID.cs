using Microsoft.EntityFrameworkCore.Migrations;

namespace CoursePlannerTwo.Migrations
{
    public partial class noTID : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "transcriptId",
                table: "courses");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<int>(
                name: "transcriptId",
                table: "courses",
                nullable: false,
                defaultValue: 0);
        }
    }
}
