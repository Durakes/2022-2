using System;
using System.Collections.Generic;

namespace test.Models
{
    public partial class Estanterium
    {
        public int IdEstanteria { get; set; }
        public int IdUsuario { get; set; }
        public string? NomEstanteria { get; set; }
        public string? FechaCreacion { get; set; }
        public bool? EsEditable { get; set; }
    }
}
