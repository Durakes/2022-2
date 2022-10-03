using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace ClaseMartes.Models
{
    public partial class bduniversidadContext : DbContext
    {
        public bduniversidadContext()
        {
        }

        public bduniversidadContext(DbContextOptions<bduniversidadContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Alumno> Alumnos { get; set; } = null!;
        public virtual DbSet<MGrado> MGrados { get; set; } = null!;
        public virtual DbSet<MMatricula> MMatriculas { get; set; } = null!;
        public virtual DbSet<MSeccion> MSeccions { get; set; } = null!;
        public virtual DbSet<MTurno> MTurnos { get; set; } = null!;

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

            modelBuilder.Entity<MGrado>(entity =>
            {
                entity.HasKey(e => e.IdGrado)
                    .HasName("PRIMARY");

                entity.ToTable("m_grado");

                entity.HasCharSet("utf8")
                    .UseCollation("utf8_general_ci");

                entity.Property(e => e.IdGrado)
                    .HasMaxLength(2)
                    .HasColumnName("Id_grado")
                    .IsFixedLength();

                entity.Property(e => e.GraDescripcion)
                    .HasMaxLength(15)
                    .HasColumnName("gra_descripcion");
            });

            modelBuilder.Entity<MMatricula>(entity =>
            {
                entity.HasKey(e => e.IdAlumno)
                    .HasName("PRIMARY");

                entity.ToTable("m_matricula");

                entity.HasCharSet("utf8")
                    .UseCollation("utf8_general_ci");

                entity.HasIndex(e => e.IdAnio, "FK__M_MATRICU__Id_an__7C4F7684");

                entity.HasIndex(e => e.IdCondicion, "FK__M_MATRICU__Id_co__00200768");

                entity.HasIndex(e => e.IdGrado, "FK__M_MATRICU__Id_gr__7E37BEF6");

                entity.HasIndex(e => e.IdNivelmodalidad, "FK__M_MATRICU__Id_ni__7F2BE32F");

                entity.HasIndex(e => e.IdSeccion, "FK__M_MATRICU__Id_se__7D439ABD");

                entity.HasIndex(e => e.IdSituacion, "FK__M_MATRICU__Id_si__7B5B524B");

                entity.HasIndex(e => e.IdTurno, "FK__M_MATRICU__Id_tu__7A672E12");

                entity.Property(e => e.IdAlumno)
                    .HasMaxLength(6)
                    .HasColumnName("Id_alumno")
                    .IsFixedLength();

                entity.Property(e => e.IdAnio)
                    .HasMaxLength(2)
                    .HasColumnName("Id_anio")
                    .IsFixedLength();

                entity.Property(e => e.IdCondicion)
                    .HasMaxLength(2)
                    .HasColumnName("Id_condicion")
                    .IsFixedLength();

                entity.Property(e => e.IdGrado)
                    .HasMaxLength(2)
                    .HasColumnName("Id_grado")
                    .IsFixedLength();

                entity.Property(e => e.IdMatricula)
                    .HasMaxLength(4)
                    .HasColumnName("Id_matricula")
                    .IsFixedLength();

                entity.Property(e => e.IdNivelmodalidad)
                    .HasMaxLength(2)
                    .HasColumnName("Id_nivelmodalidad")
                    .IsFixedLength();

                entity.Property(e => e.IdSeccion)
                    .HasMaxLength(2)
                    .HasColumnName("Id_seccion")
                    .IsFixedLength();

                entity.Property(e => e.IdSituacion)
                    .HasMaxLength(1)
                    .HasColumnName("Id_situacion")
                    .IsFixedLength();

                entity.Property(e => e.IdTurno)
                    .HasMaxLength(1)
                    .HasColumnName("Id_turno")
                    .IsFixedLength();

                entity.Property(e => e.MatEstado)
                    .HasMaxLength(1)
                    .HasColumnName("mat_estado")
                    .IsFixedLength();

                entity.Property(e => e.MatFecha)
                    .HasMaxLength(10)
                    .HasColumnName("mat_fecha")
                    .IsFixedLength();

                entity.Property(e => e.MatResponsable)
                    .HasMaxLength(15)
                    .HasColumnName("mat_responsable");
            });

            modelBuilder.Entity<MSeccion>(entity =>
            {
                entity.HasKey(e => e.IdSeccion)
                    .HasName("PRIMARY");

                entity.ToTable("m_seccion");

                entity.HasCharSet("utf8")
                    .UseCollation("utf8_general_ci");

                entity.Property(e => e.IdSeccion)
                    .HasMaxLength(2)
                    .HasColumnName("Id_seccion")
                    .IsFixedLength();

                entity.Property(e => e.SecDescripcion)
                    .HasMaxLength(5)
                    .HasColumnName("sec_descripcion");
            });

            modelBuilder.Entity<MTurno>(entity =>
            {
                entity.HasKey(e => e.IdTurno)
                    .HasName("PRIMARY");

                entity.ToTable("m_turno");

                entity.HasCharSet("utf8")
                    .UseCollation("utf8_general_ci");

                entity.Property(e => e.IdTurno)
                    .HasMaxLength(1)
                    .HasColumnName("Id_turno")
                    .IsFixedLength();

                entity.Property(e => e.TurAbreviacion)
                    .HasMaxLength(2)
                    .HasColumnName("tur_abreviacion")
                    .IsFixedLength();

                entity.Property(e => e.TurDescripcion)
                    .HasMaxLength(15)
                    .HasColumnName("tur_descripcion");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
