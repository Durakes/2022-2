using Microsoft.AspNetCore.Mvc;

namespace ClaseMartes.Controllers
{
    public class AlumnoController : Controller
    {
        private readonly bduniversidadContext Context;

        public AlumnoController(bduniversidadContext context)
        {
            Context = context;
        }
        [HttpGet]
        public IActionResult Index()
        {
            var list = Context.Alumnos;
            return View(list);
        }
        [HttpGet]

        public IActionResult Listar()
        {
            return View();
        }
    }
}
