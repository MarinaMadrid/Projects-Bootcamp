describe('Pruebas de crear y borrar tareas', () => {

  it('Crear Tarea', () => {
    cy.visit("http://mmgtestingangular.web.app/").then(() => {
      cy.contains('Agregar').click();
      cy.get('[placeholder="Número de tarea"]').type(8000);
      cy.get('[placeholder="Número de usuario"]').type(26);
      cy.get('[placeholder="Texto de la tarea"]').type("Test de Crear Tarea de Cypress");
      cy.get('[placeholder="Fecha de creación"]').type("2021-10-23");
      cy.get('[name="status2"]').type("pending");
      cy.contains('Guardar').click();
      cy.contains('Volver').click();
    });
  });


  it('Borrar Tarea', () => {
      cy.visit("http://mmgtestingangular.web.app/").then(() => {
        cy.contains('Agregar').click();
        cy.get('[placeholder="Número de tarea"]').type(8000);
        cy.get('[placeholder="Número de usuario"]').type(26);
        cy.get('[placeholder="Texto de la tarea"]').type("Test de Crear Tarea de Cypress");
        cy.get('[placeholder="Fecha de creación"]').type("2021-10-23");
        cy.get('[name="status2"]').type("pending");
        cy.contains('Guardar').click();
        cy.contains('Volver').click();
        cy.contains('Borrar').click();
      });
  });


});
