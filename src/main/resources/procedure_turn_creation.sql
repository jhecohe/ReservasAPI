CREATE OR REPLACE PROCEDURE turn_creation (
    fechainicio DATE,
    fechafin    DATE,
    idservicio  NUMBER
) IS
    bookdate    DATE := fechainicio;
    r_servicing servicing%rowtype;
    opendate    DATE;
    enddate     DATE;
BEGIN
    SELECT
        *
    INTO r_servicing
    FROM
        servicing s
    WHERE
        s.id = idservicio;

    WHILE bookdate <= fechafin LOOP
        opendate := r_servicing.open;
        WHILE opendate <= r_servicing.close LOOP
            enddate := opendate + ( r_servicing.duration / 1440 );
            INSERT INTO turn (
                id,
                turn_date,
                start_date,
                end_date,
                turn_status,
                service_id
            ) VALUES (
                turn_seq.NEXTVAL,
                bookdate,
                opendate,
                enddate,
                'FREE',
                idservicio
            );

            opendate := enddate;
        END LOOP;

        bookdate := bookdate + 1;
    END LOOP;

END;