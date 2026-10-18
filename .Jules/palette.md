# Journal Learning: UX en Campos de Texto (Compose)

## Semantic ImeAction & Clear Buttons
- **Clear Trailing Icon:** En campos de búsqueda de catálogo, permitir que las usuarias borren la consulta con un solo toque (`IconButton` con icono `Clear`) reduce la fricción en comparación con pulsar repetidamente la tecla retroceso.
- **ImeAction.Search & ImeAction.Go:** 
  - En `CatalogScreen`: `ImeAction.Search` avisa al teclado virtual que oculte el foco y teclado tras buscar.
  - En `LoginScreen`: `ImeAction.Go` permite enviar el formulario directamente al pulsar la tecla Enter / Enviar en el teclado en pantalla, evitando obligar a la usuaria a cerrar el teclado y presionar manualmente el botón "Entrar".
