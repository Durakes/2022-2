using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace DBPFinal.Models
{
    public partial class bdfinalContext : DbContext
    {
        public bdfinalContext()
        {
        }

        public bdfinalContext(DbContextOptions<bdfinalContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Alumno> Alumnos { get; set; } = null!;
        public virtual DbSet<MObligacion> MObligacions { get; set; } = null!;
        public virtual DbSet<TPago> TPagos { get; set; } = null!;

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.UseCollation("utf8mb4_general_ci")
                .HasCharSet("utf8mb4");

            modelBuilder.Entity<Alumno>(entity =>
            {
                entity.HasKey(e => e.IdAlumno)
                    .HasName("PRIMARY");

                entity.ToTable("alumno");

                entity.HasCharSet("utf8")
                    .UseCollation("utf8_general_ci");

                entity.HasIndex(e => e.IdEstadocivil, "FK__ALUMNO__Id_estad__5CD6CB2B");

                entity.Property(e => e.IdAlumno)
                    .HasMaxLength(6)
                    .HasColumnName("Id_alumno")
                    .IsFixedLength();

                entity.Property(e => e.AluCodigo)
                    .HasMaxLength(14)
                    .HasColumnName("alu_codigo")
                    .IsFixedLength();

                entity.Property(e => e.AluEmail)
                    .HasMaxLength(50)
                    .HasColumnName("alu_email");

                entity.Property(e => e.AluMaterno)
                    .HasMaxLength(35)
                    .HasColumnName("alu_materno");

                entity.Property(e => e.AluNombres)
                    .HasMaxLength(50)
                    .HasColumnName("alu_nombres");

                entity.Property(e => e.AluPaterno)
                    .HasMaxLength(35)
                    .HasColumnName("alu_paterno");

                entity.Property(e => e.AluSexo)
                    .HasMaxLength(1)
                    .HasColumnName("alu_sexo")
                    .IsFixedLength();

                entity.Property(e => e.IdEstadocivil)
                    .HasMaxLength(1)
                    .HasColumnName("Id_estadocivil");
            });

            modelBuilder.Entity<MObligacion>(entity =>
            {
                entity.HasKey(e => e.IdObligacion)
                    .HasName("PRIMARY");

                entity.ToTable("m_obligacion");

                entity.HasCharSet("utf8")
                    .UseCollation("utf8_general_ci");

                entity.HasIndex(e => e.IdAlumno, "FK__M_OBLIGAC__Id_al__03F0984C");

                entity.HasIndex(e => e.IdDescripcionobligacion, "FK__M_OBLIGAC__Id_de__02FC7413");

                entity.Property(e => e.IdObligacion)
                    .HasMaxLength(10)
                    .HasColumnName("Id_obligacion")
                    .IsFixedLength();

                entity.Property(e => e.IdAlumno)
                    .HasMaxLength(6)
                    .HasColumnName("Id_alumno")
                    .IsFixedLength();

                entity.Property(e => e.IdDescripcionobligacion)
                    .HasMaxLength(3)
                    .HasColumnName("Id_descripcionobligacion")
                    .IsFixedLength();

                entity.Property(e => e.OblMontoobligacion)
                    .HasPrecision(9, 2)
                    .HasColumnName("obl_montoobligacion");

                entity.Property(e => e.OblVencimiento)
                    .HasMaxLength(10)
                    .HasColumnName("obl_vencimiento")
                    .IsFixedLength();
            });

            modelBuilder.Entity<TPago>(entity =>
            {
                entity.HasKey(e => new { e.IdObligacion, e.PagoNumero })
                    .HasName("PRIMARY")
                    .HasAnnotation("MySql:IndexPrefixLength", new[] { 0, 0 });

                entity.ToTable("t_pago");

                entity.HasCharSet("utf8")
                    .UseCollation("utf8_general_ci");

                entity.Property(e => e.IdObligacion)
                    .HasMaxLength(10)
                    .HasColumnName("Id_obligacion")
                    .IsFixedLength();

                entity.Property(e => e.PagoNumero)
                    .HasMaxLength(2)
                    .HasColumnName("pago_numero")
                    .IsFixedLength();

                entity.Property(e => e.Comprobante)
                    .HasMaxLength(10)
                    .HasColumnName("comprobante")
                    .IsFixedLength();

                entity.Property(e => e.PagoImporte)
                    .HasPrecision(9, 2)
                    .HasColumnName("pago_importe");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
