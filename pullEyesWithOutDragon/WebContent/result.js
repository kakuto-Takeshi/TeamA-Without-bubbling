let a=5000;
let b=1000;
let app=new Vue({
	el:'#app',
	data:{

		show:true,

		momo:{
			masege:["Thank you..."],
			masege2:[],
			masege3:[],
			masege4:[],
			masege5:[],


		},


	},
	methods :{
		audio:function(){
			audioElem = new Audio();
		      audioElem.src = "video/129.mp3";
		      audioElem.play();

		},
		audio2:function(){
			audioElem = new Audio();
		      audioElem.src = "video/end.mp3";
		      audioElem.play();

		},
		Delete: function() {
  			this.momo.masege.splice(0,1)

  		},
  		Delete2: function() {
  			this.momo.masege2.splice(0,1)

  		},
  		Delete3: function() {
  			this.momo.masege4.splice(0,1)

  		},
  		Delete4: function() {
  			this.momo.masege5.splice(0,1)

  		},

		kakutou:function(){
			this.show = !this.show

			setTimeout(this.bonds, 1000);
//			setTimeout(this.bonds44, 1000);

			},
			bonds: function() {
				setTimeout(this.Delete, 100);

			   this.momo.masege.push("人生という限りある時間の中で")
			   setTimeout(this.bonds1, a);
			},
	  		bonds1: function() {
	  			this.Delete();
	  			this.momo.masege.push("あの日僕たちはどんな夢をみて")
	  			setTimeout(this.bonds2, a);
	  		},
	  		bonds2: function() {
	  			this.Delete();
	  			this.momo.masege.push("君に出会ったのだろう？")
	  			setTimeout(this.bonds3, a);
	  		},
	  		bonds3: function() {
		  		this.Delete();
		  		this.momo.masege.push("忘れられた過去も")
		  		setTimeout(this.bonds4, a);
	  		},
		  	bonds4: function() {
			  	this.Delete();
			  	this.momo.masege.push("癒えない傷も")
			  	setTimeout(this.bonds5, a);
			},
			bonds5: function() {
				  this.Delete();
				  this.momo.masege.push("全てがこの日の")
				  setTimeout(this.bonds6, a);
			},
			bonds6: function() {
				this.Delete();
				this.momo.masege.push("ためだったのなら...")
				setTimeout(this.bonds7, a);
			},
			bonds7: function() {
				this.Delete();
				this.audio();
				this.momo.masege2.push("1")
				setTimeout(this.bonds8, a);
			},
			bonds8: function() {
				this.Delete2();
				this.momo.masege.push("年齢も趣味も思考も様々で")
				setTimeout(this.bonds9, a);
			},
			bonds9: function() {
				this.Delete();
				this.momo.masege2.push("106")
				setTimeout(this.bonds11, a);
			},
			bonds11: function() {
				this.Delete2();
				this.momo.masege.push("それぞれが希望と不安を抱いて")
				setTimeout(this.bonds12, a);
			},
			bonds12: function() {
				this.Delete();
				this.momo.masege2.push("3")
				setTimeout(this.bonds14, a);
			},
			bonds14: function() {
				this.Delete2();
				this.momo.masege.push("ここに集まり踏み出した一歩")
				setTimeout(this.bonds15, a);
			},
			bonds15: function() {
				this.Delete();
				this.momo.masege2.push("4")
				setTimeout(this.bonds17, a);
			},
			bonds17: function() {
				this.Delete2();
				this.momo.masege4.push("5")
				setTimeout(this.bonds18, a);
			},
			bonds18: function() {
				this.Delete3();
				this.momo.masege.push("「おはよう」")
				setTimeout(this.bonds19, a);
			},
			bonds19: function() {
				this.Delete();
				this.momo.masege.push("「はじめまして、よろしくね」")
				setTimeout(this.bonds22, a);
			},

			bonds22: function() {
				this.Delete();
				this.momo.masege2.push("6")
				setTimeout(this.bonds23, 3000);
		},
			bonds23: function() {
				this.Delete2();
				this.momo.masege.push("そんな当たり前の一言が")
				setTimeout(this.bonds25, a);
			},
			bonds25: function() {
				this.Delete();
				this.momo.masege2.push("7")
				setTimeout(this.bonds27, a);
			},
			bonds27: function() {
				this.Delete2();
				this.momo.masege.push("うまく言えず初日は緊張したよね")
				setTimeout(this.bonds28, a);
			},
			bonds28: function() {
				this.Delete();
				this.momo.masege2.push("10")
				setTimeout(this.bonds29, a-b);
			},
			bonds29: function() {
				this.Delete2();
				this.momo.masege4.push("8")
				setTimeout(this.bonds30, a-b);
			},
			bonds30: function() {
				this.Delete3();
				this.momo.masege.push("何もわからない僕たちに")
				setTimeout(this.bonds31, a-b);
			},

			bonds31: function() {
				this.Delete();
				this.momo.masege2.push("9")
				setTimeout(this.bonds323, a-b);
			},
			bonds323: function() {
				this.Delete2();
				this.momo.masege4.push("11")
				setTimeout(this.bonds32, a-b);
			},
			bonds32: function() {
				this.Delete3();
				this.momo.masege.push("優しく接してくれたのは")

				setTimeout(this.bonds322, a);
			},
			bonds322: function() {
				this.Delete();
				setTimeout(this.bonds33, 2500);
			},
			bonds33: function() {

				this.momo.masege.push("先生たちでした")
				setTimeout(this.bonds34, a);
			},
			bonds34: function() {
				this.Delete();
				this.momo.masege2.push("R")
				setTimeout(this.bonds35, a);
			},
			bonds35: function() {
				this.Delete2();
				this.momo.masege4.push("ss")
				setTimeout(this.bonds36, a);
			},
			bonds36: function() {
				this.Delete3();
				this.momo.masege5.push("yteacher")
				setTimeout(this.bonds37, a);
			},
			bonds37: function() {
				this.Delete4();
				this.momo.masege.push("短い間でしたが")
				setTimeout(this.bonds38, a);
			},
			bonds38: function() {
				this.Delete();
				this.momo.masege.push("ありがとうございました")

				setTimeout(this.bonds39, 10000);
			},
			bonds39: function() {

				this.Delete();
				this.momo.masege.push("あの日、僕たちはどんな夢を見て")
				setTimeout(this.bonds40, a);
			},
			bonds40: function() {
				this.Delete();
				this.momo.masege.push("君に出会ったのだろう？")
				setTimeout(this.bonds41, a);
			},
			bonds41: function() {
				this.Delete();
				this.momo.masege.push("今日も世界が廻るなら")
				setTimeout(this.bonds42, a);
			},
			bonds42: function() {
				this.Delete();
				this.momo.masege.push("僕たちはきっと続いていく...")
				setTimeout(this.bonds43, 7000);
			},
			bonds43: function() {
				this.Delete();
				this.momo.masege.push("過去の意味も変えていける")
				setTimeout(this.bonds44, 7000);

			},
			bonds44: function() {
				this.Delete();
				this.momo.masege3.push("　　Mesage for march Java students　　from Ateam")

			},

	}
});
