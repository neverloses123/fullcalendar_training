/**
 *
 */
activateMenu('project');

//$(document).ready(function () {
//    //query();
//
//});

//_changeCompany();
//query();


function _clear(){
    $('#projectName').val('');
    $('#projectCustomerId').val('');
    $('#projectMemberId').val('');
    $('#projectState').val('');
    return false;
}

function querySubmit(){
    //no criteria need validation

    query();
    //return true;
}

 function query() {
	$('#_loadingModal').modal('show');

    $('#data_table').DataTable().destroy();
    oTable = $('#data_table').DataTable({
      "processing": true,
      "serverSide": false,
      "destroy": true,
      "filter": false,
      "ajax": {
        "cache": false,
        "url": appPath+"/api/project/listAll",
        "type": "POST",
        "dataSrc": function ( data ) {
          //console.log('data in dataSrc='+JSON.stringify(data));
          var count=data['list'].length;
          data["recordsTotal"]= count;
          data["recordsFiltered"]= count;

          return data['list'];
        },
        "data": function (sSource, aoData, fnCallback) {
          return $('#queryForm').serialize();
        }
      },
      "pageLength": 10,
      "paginate": true,
      "paging": true,
      "pagingType": "full_numbers",
      "ordering": false,
      "lengthChange": false,
      "language":{
        "paginate": {
          "first":"第一頁",
          "previous": "前一頁",
          "next": "下一頁",
          "last":"最後一頁"
        },
        "zeroRecords": "查無資料",
        "processing": "查詢中..."
      },
      "info": true,
      "autoWidth": false,
      "columns": [
        { "data": "projectName" },
        { "data": "projectCustomerId" },
		{ "data": "projectMemberId" },
		{ "data": "projectState" },
        {
//            "data": function (source, type, val) {
//                var edit='<i class="fa fa-edit fa-lg text-primary" aria-hidden="true" onclick="location.href=\''+appPath+'/apt/project/edit/'+source.id+'\'"></i>&nbsp;';
//                edit+='<i class="fa fa-trash fa-lg text-danger" aria-hidden="true" onclick="initDelete('+source.id+');"></i>';
//                return edit;
//            }
        }
      ],
      "initComplete": function (settings, json) {
		$('#_loadingModal').modal('hide');
      }
 });

}

function initDelete(delId){
	$('#deleteModalCenter').modal('show');
	$('#option').val(delId);
}

//$(document).on("click", "#btnSureAction", function(event){
//	var delId=parseInt($('#option').val());
//
//    $('#deleteModalCenter').modal('hide');
//    //doDelete(delId);
//});

//function doDelete(id){
//    call_get_api(appPath+'/api/project/del/'+id, callback_delete);
//}

//function callback_delete(data){
//    //console.log('data='+JSON.stringify(data));
//    if(data.status=='success'){
//        $('#data_table').DataTable().ajax.reload();
//    }else{
//        alertMessage('刪除客戶資料失敗，請聯繫系統管理員。');
//    }
//}
