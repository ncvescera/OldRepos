function rmbPress(event,id){
  //premuto tasto destro mouse
  if(event.button == 2){
    //alert($("#"+id).text());
    var val = $("#"+id).text();
    $("#tr_"+id).html("<input type=\"text\" value=\""+val+"\" onkeyup=\"escPress(event); enterPress(event,\'"+id+"\',this.value)\" class=\"form-control\">");
  }

}
