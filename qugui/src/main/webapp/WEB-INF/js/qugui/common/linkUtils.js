/**
 * Created by Nandem on 2017-05-07.
 */
function redirectReplace(id)
{
    var $objContainHref = $("#" + id);
    window.location.replace($objContainHref.attr("href"));
}
function redirectLink(id)
{
    var $objContainHref = $("#" + id);
    window.location.href = $objContainHref.attr("href");
}
function redirectOpen(id)
{
    var $objContainHref = $("#" + id);
    window.open($objContainHref.attr("href"));
}