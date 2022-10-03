using Microsoft.AspNetCore.Mvc;

namespace Ruteo.Controllers
{
    public class ProductoController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
        [Route("ope")]
        public IActionResult Operaciones()
        {
            ViewData["dato"] = "Suma de dos numeros";   
            return View();
        }
        [Route("ope/operaciones2")]
        public IActionResult Operaciones2(string nombre, string apellidos)
        {
            ViewData["nom"] = nombre;
            ViewData["ape"] = apellidos;
            return View();
        }
        [Route("ope/operaciones3/{nombre}")]
        public IActionResult Operaciones3(string nombre, string apellidos)
        {
            ViewData["nom"] = nombre;
            ViewData["ape"] = apellidos;
            return View();
        }
        [Route("ope/operaciones4/{nombre}")]
        public IActionResult Operaciones4(string nombre)
        {
            return View("Operaciones4", nombre);
        }
        public IActionResult Operaciones5(string txtNota1, string txtNota2, string txtNota3, string txtNota4)
        {
            ViewData["n1"] = txtNota1;
            ViewData["n2"] = txtNota2;
            ViewData["n3"] = txtNota3;
            ViewData["n4"] = txtNota4;
            return View();
        }
    }
}
