//#titleを取得
let title = document.getElementById('title');
//#backgroundを取得
let background = document.getElementById('background');

document.addEventListener('mousemove', event => {

  //X座標(値は適宜調整)
  var x = Math.round(event.pageX / 100);
  //Y座標(値は適宜調整)
  var y = Math.round(event.pageY / 100);
  
  //#titleのX軸・Y軸を設定
  title.style.marginLeft = -x +'px';
  title.style.marginTop = -y +'px';
  
  //#backgroundのX軸・Y軸を設定
  background.style.marginLeft = x +'px';
  background.style.marginTop = y +'px';
});