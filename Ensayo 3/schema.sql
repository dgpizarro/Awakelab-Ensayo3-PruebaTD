CREATE TABLE alumno (
    idalumno  INTEGER NOT NULL,
    idcurso   INTEGER NOT NULL,
    nombre    VARCHAR2(100 CHAR) NOT NULL
);

ALTER TABLE alumno ADD CONSTRAINT alumno_pk PRIMARY KEY ( idalumno );

CREATE TABLE curso (
    idcurso  INTEGER NOT NULL,
    nombre   VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE curso ADD CONSTRAINT curso_pk PRIMARY KEY ( idcurso );

ALTER TABLE alumno
    ADD CONSTRAINT alumno_curso_fk FOREIGN KEY ( idcurso )
        REFERENCES curso ( idcurso );