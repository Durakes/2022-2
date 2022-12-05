using System;
using System.Collections.Generic;

namespace test.Models
{
    public partial class PeliculaEstanterium
    {
        public int IdPelicula { get; set; }
        public int IdEstanteria { get; set; }
        public string? FechaAgregacion { get; set; }
    }
}
