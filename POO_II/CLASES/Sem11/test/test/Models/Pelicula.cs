using System;
using System.Collections.Generic;

namespace test.Models
{
    public partial class Pelicula
    {
        public int IdPelicula { get; set; }
        public int? IdTmdb { get; set; }
        public int? IdIdioma { get; set; }
        public string? NomPelicula { get; set; }
        public string? FechaEstreno { get; set; }
        public decimal? Valoracion { get; set; }
        public string? Sumilla { get; set; }
        public string? UrlFoto { get; set; }
    }
}
