/**
* @Nandem by Nandem on 2017-03-30.
*/

$(document).ready(function()
{
    $('#fullpage').fullpage(
    {
        //Navigation
        menu: '#myMenu',
        lockAnchors: true,
        anchors:['firstPage', 'secondPage'],
        navigation: true,
        navigationPosition: 'right',
        navigationTooltips: ['firstSlide', '初识', '相知', '游走', '熟悉', '熟悉', '离别', '提交'],
        showActiveTooltip: false,
        slidesNavigation: false,
        slidesNavPosition: 'bottom',

        //Scrolling
        css3: true,
        scrollingSpeed: 700,
        autoScrolling: true,
        fitToSection: true,
        fitToSectionDelay: 1000,
        // scrollBar: true,
        easing: 'easeInOutCubic',
        easingcss3: 'ease',
        loopBottom: false,
        loopTop: false,
        loopHorizontal: true,
        continuousVertical: false,
        continuousHorizontal: false,
        scrollHorizontally: false,
        interlockedSlides: false,
        dragAndMove: false,
        offsetSections: false,
        resetSliders: false,
        fadingEffect: false,
        normalScrollElements: '#element1, .element2',
        scrollOverflow: false,
        scrollOverflowReset: false,
        scrollOverflowOptions: null,
        touchSensitivity: 15,
        normalScrollElementTouchThreshold: 5,
        bigSectionsDestination: null,

        //Accessibility
        keyboardScrolling: true,
        animateAnchor: true,
        recordHistory: true,

        //Design
        controlArrows: true,
        verticalCentered: true,
        sectionsColor: ['#FFFFFF', '#000000', '#FFFFFF', '#000000', '#FFFFFF', '#000000', '#FFFFFF'],
        // paddingTop: '3em',
        // paddingBottom: '10px',
        fixedElements: '#header, .footer',
        responsiveWidth: 0,
        responsiveHeight: 0,
        responsiveSlides: false,
        parallax: false,
        parallaxOptions: {type: 'reveal', percentage: 62, property: 'translate'},

        //Custom selectors
        sectionSelector: '.section',
        slideSelector: '.slide',

        lazyLoading: true,

        //events
        onLeave: function(index, nextIndex, direction)
        {
            // layer.msg("direction:" + direction + " nextIndex:" + nextIndex);
        },
        afterLoad: function(anchorLink, index)
        {
            // layer.msg("anchorLink:" + anchorLink + " index:" + index);
        },
        afterRender: function()
        {
            //整个页面只会执行一次该回调方法
            layer.msg("渲染完毕");
        },
        afterResize: function()
        {

        },
        afterResponsive: function(isResponsive)
        {
            layer.msg("isResponsive：" + isResponsive);
        },
        afterSlideLoad: function(anchorLink, index, slideAnchor, slideIndex)
        {

        },
        onSlideLeave: function(anchorLink, index, slideIndex, direction, nextSlideIndex)
        {

        }
    });
});