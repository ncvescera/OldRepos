function enterPress(event,id,value) {
  //pressione tasto enter
  if(event.keyCode == 13){
    //alert("enter predded "+id+"\n"+value);
    editRagazza(id,value);
  }
}
