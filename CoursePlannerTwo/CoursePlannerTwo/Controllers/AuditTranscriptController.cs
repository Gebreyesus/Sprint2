using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using System.Text.Encodings.Web;

namespace CoursePlannerTwo.Controllers
{
    public class AuditTranscriptController : Controller
    {
        public IActionResult Index()
        {
           
            return View();
        }

        public string Test()
        {
            return HtmlEncoder.Default.Encode("Hello");
        }
    }
}