/**
* @Nandem by Nandem on 2017-03-30.
*/

$(document).ready(function()
{

    var $oSlideLeftBtn = $("#slideLeftBtn");
    var $oSlideRightBtn = $("#slideRightBtn");
    var $oFirstSlideNextBtn = $("#firstSlideNextBtn");

    $('#fullpage').fullpage(
    {
        //Navigation
        menu: '#myMenu',
        lockAnchors: true,
        anchors:['firstPage', 'secondPage'],
        navigation: false,
        navigationPosition: 'right',
        navigationTooltips: ['编辑', '确定', '提交'],
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
        controlArrows: false,
        verticalCentered: true,
        sectionsColor: ['#FFFFFF', '#FFFFFF', '#FFFFFF'],
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
            // layer.msg("渲染完毕");
            $oSlideLeftBtn.hide();
            $oSlideRightBtn.hide();
        },
        afterResize: function()
        {

        },
        afterResponsive: function(isResponsive)
        {
        },
        afterSlideLoad: function(anchorLink, index, slideAnchor, slideIndex)
        {
        },
        onSlideLeave: function(anchorLink, index, slideIndex, direction, nextSlideIndex)
        {
            if(nextSlideIndex == 0)
            {
                $oSlideLeftBtn.hide('slow');
                $oSlideRightBtn.hide('slow');
            }
            else
            {
                $oSlideLeftBtn.show('slow');
                $oSlideRightBtn.show('slow');
            }
        }
    });

    $oSlideLeftBtn.click(function ()
    {
        $.fn.fullpage.moveSlideLeft();
    });

    $oSlideRightBtn.click(function ()
    {
        $.fn.fullpage.moveSlideRight();
    });

    $oFirstSlideNextBtn.click(function ()
    {
        $.fn.fullpage.moveSlideRight();
    });
});