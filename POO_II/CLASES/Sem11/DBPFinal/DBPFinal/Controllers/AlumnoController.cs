using DBPFinal.Models;
using Microsoft.AspNetCore.Mvc;

namespace DBPFinal.Controllers
{
    public class AlumnoController : Controller
    {
        private readonly bdfinalContext Context;
        public AlumnoController(bdfinalContext context)
        {
            Context = context;
        }

        public IActionResult Index()
        {
            var listaPago = (from pago in Context.TPagos
                             join obl in Context.MObligacions on pago.IdObligacion equals obl.IdObligacion
                             join alu in Context.Alumnos on obl.IdAlumno equals alu.IdAlumno
                             select new Prueba
                             {
                                 pagoInfo = pago,
                                 oblInfo = obl,
                                 aluInfo = alu
                             }) ;

            return View(listaPago);
        }
    }
}
