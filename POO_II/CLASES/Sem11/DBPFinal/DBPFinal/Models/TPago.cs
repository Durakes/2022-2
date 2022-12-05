using System;
using System.Collections.Generic;

namespace DBPFinal.Models
{
    public partial class TPago
    {
        public string PagoNumero { get; set; } = null!;
        public string IdObligacion { get; set; } = null!;
        public decimal? PagoImporte { get; set; }
        public string? Comprobante { get; set; }
    }
}
