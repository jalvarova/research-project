jQuery(function($){
    $.supersized({
        // Funcionalidad
        slide_interval     : 4000,    // Tamaño entre Transiciones
        transition         : 1,    // 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
        transition_speed   : 1000,    // Velocidad de Transicion
        performance        : 1,    // 0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)
        // Tamaño y Posición
        min_width          : 0,    // Minimo Ancho Permitido (en pixeles)
        min_height         : 0,    // Minima Altura Permitida (en pixeles)
        vertical_center    : 1,    
        horizontal_center  : 1,    
        fit_always         : 0,    
        fit_portrait       : 1,    
        fit_landscape      : 0,    

        slide_links        : 'blank',    // Enlaces Individuales por cada Slide (Opciones: false, 'num', 'name', 'blank')
        slides             : [    // Imagenes
                                 {image : 'Imagenes/1.jpg'},
                                 {image : 'Imagenes/2.jpg'},
                                 {image : 'Imagenes/3.jpg'}
                             ]
    });
});