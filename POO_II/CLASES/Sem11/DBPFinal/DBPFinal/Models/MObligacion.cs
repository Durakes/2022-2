using System;
using System.Collections.Generic;

namespace DBPFinal.Models
{
    public partial class MObligacion
    {
        public string IdObligacion { get; set; } = null!;
        public string? OblVencimiento { get; set; }
        public decimal? OblMontoobligacion { get; set; }
        public string? IdAlumno { get; set; }
        public string? IdDescripcionobligacion { get; set; }
    }
}
