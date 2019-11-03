$(document).ready(function () {
    $('.delete-phone').on('click', function () {
        /*<![CDATA[*/
        var path = /*[[@{/]]*/'remove';
        /*]]>*/
        var id = $(this).attr('id');

        bootbox.confirm({
            message: "Are you sure to remove this phone? It can't be undone.",
            buttons: {
                cancel: {
                    label: '<i class="fa fa-times"></i> Cancel'
                },
                confirm: {
                    label: '<i class="fa fa-check"></i> Confirm'
                }
            },
            callback: function (confirmed) {
                if (confirmed) {
                    $.post(path, {'id': id}, function (res) {
                        location.reload();
                    });
                }
            }

        });

    });
});