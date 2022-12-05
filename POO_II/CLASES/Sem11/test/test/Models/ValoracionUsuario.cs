using System;
using System.Collections.Generic;

namespace test.Models
{
    public partial class ValoracionUsuario
    {
        public int IdPelicula { get; set; }
        public int IdUsuario { get; set; }
        public int? Valoracion { get; set; }
        public bool? EstaVisto { get; set; }
        public string? FechaValoracion { get; set; }
    }
}
