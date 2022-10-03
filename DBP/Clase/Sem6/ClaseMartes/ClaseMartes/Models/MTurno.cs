using System;
using System.Collections.Generic;

namespace ClaseMartes.Models
{
    public partial class MTurno
    {
        public string IdTurno { get; set; } = null!;
        public string? TurDescripcion { get; set; }
        public string? TurAbreviacion { get; set; }
    }
}
