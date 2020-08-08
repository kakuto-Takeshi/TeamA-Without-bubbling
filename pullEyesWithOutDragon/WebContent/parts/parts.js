//#title���擾
let title = document.getElementById('title');
//#background���擾
let background = document.getElementById('background');

document.addEventListener('mousemove', event => {

  //X���W(�l�͓K�X����)
  var x = Math.round(event.pageX / 100);
  //Y���W(�l�͓K�X����)
  var y = Math.round(event.pageY / 100);
  
  //#title��X���EY����ݒ�
  title.style.marginLeft = -x +'px';
  title.style.marginTop = -y +'px';
  
  //#background��X���EY����ݒ�
  background.style.marginLeft = x +'px';
  background.style.marginTop = y +'px';
});