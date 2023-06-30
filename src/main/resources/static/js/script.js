$(document).ready(function() {
    var w = window.innerWidth;

    if (w > 767) {
        $('#menu-jk').scrollToFixed();
    } else {
        // $('#menu-jk').scrollToFixed();
    }

    $("#testimonial-slider").owlCarousel({
        items: 2,
        itemsDesktop: [1000, 2],
        itemsDesktopSmall: [979, 2],
        itemsTablet: [768, 1],
        pagination: false,
        navigation: true,
        navigationText: ["", ""],
        autoPlay: true
    });

    $(".filter-button").click(function() {
        var value = $(this).attr('data-filter');

        if (value == "all") {
            //$('.filter').removeClass('hidden');
            $('.filter').show('1000');
        } else {
            // $('.filter[filter-item="'+value+'"]').removeClass('hidden');
            // $(".filter").not('.filter[filter-item="'+value+'"]').addClass('hidden');
            $(".filter").not('.' + value).hide('3000');
            $('.filter').filter('.' + value).show('3000');
        }

        // toggle active class on filter buttons
        $(".filter-button").removeClass("active");
        $(this).addClass("active");
    });
});


