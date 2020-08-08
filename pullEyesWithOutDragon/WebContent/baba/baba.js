let index=0;
let nana=0;
let aaa=0;
let bbb=13;
let ccc=26;
let ddd=39;

let e=13;
let f=12;
let g=12;
let h=12;
let ee=1;
let ff=0;
let gg=0;
let hh=0;
let ii=0;
let jj=0;
let kk=0;
new Vue({
	el : '#app',
	data : {
		show:true,
		moveTime: 800,
		showTime: 100,
		cards: "cards1",
		player1: null,
		player2: null,
		player3: null,
		player4: null,
		isono: null,
		obj : {
			obj1 : [],
			obj2 : [],
			obj3 : [],
			obj4 :[],
			dust :[]
		},
		objx : {
			objx2 : [],
			objx3 : [],
			objx4 :[],
		},
		sag : {
			sag1 : [ 0,1, 2, 3, 4,5,6,7,8,9,10,11,12],
			sag2 : [13,14,15,16,17,18,19,20,21,22,23,24,25],
			sag3 : [26,27,28,29,30,31,32,33,34,35,36,37,38],
			sag4 :[39,40,41,42,43,44,45,46,47,48,49,50,51,52],
			dust :[]
		},
		osinosinobu : {
			osinosinobu1 : [],
			osinosinobu2 : [],
			osinosinobu3 : [],
			osinosinobu4 :[],
			dust :[]
		},
		yuichan : [],
	},

	methods : {

		kakutou:function(){
			this.show = !this.show
			audioElem = new Audio();
			audioElem.src = "mugic/yuugiou.mp3";
			audioElem.play();
			this.start();
		},

		start : function() {
			self = this;
			axios
				.post('http://localhost:8080/pullEyesWithOutDragon/Baba')
				.then(function(res){
					console.log(res.data);

					self.sag.sag1 = res.data.init[0];
					self.sag.sag2 = res.data.init[1];
					self.sag.sag3 = res.data.init[2];
					self.sag.sag4 = res.data.init[3];

					self.osinosinobu.osinosinobu1 = res.data.initClear[0];
					self.osinosinobu.osinosinobu2 = res.data.initClear[1];
					self.osinosinobu.osinosinobu3 = res.data.initClear[2];
					self.osinosinobu.osinosinobu4 = res.data.initClear[3];

					self.yuichan = res.data.initDust;

					self.init();
//					self.init13();
				})
				.catch(function(res){
					console.log(res);
				});
		},

		choice : function(index) {
			audioElem = new Audio();
		      audioElem.src = "kaiba/oretann.mp3";
		      audioElem.play();
			self = this;
			var params = new URLSearchParams();
			params.append('index', index);
			axios
				.post('http://localhost:8080/pullEyesWithOutDragon/Baba',params)
				.then(function(res){
					console.log(res.data);
					self.move1(res);
				})
				.catch(function(res){
					console.log(res);
				});
		},

		choice3 : function(index) {
			if(self.objx.objx2.length == 0){
				this.choice(index);
			}
		},

		choice4 : function(index) {
			if(self.objx.objx2.length == 0 && self.obj.obj3.length){
				this.choice(index);
			}
		},

		move1: function(res){
			this.obj.obj1 = res.data.playerList[0][0];
			this.objx.objx2 = res.data.playerList[1][2];
			setTimeout(this.deleteCard1, this.moveTime, res);
		},
		deleteCard1: function(res){
			this.obj.obj1 = res.data.playerList[0][1];
			this.obj.dust = res.data.dustbox[0];
			setTimeout(this.move2, this.moveTime, res);
		},
		move2: function(res){
			this.objx.objx2 = res.data.playerList[1][0];
			this.objx.objx3 = res.data.playerList[2][2];
			setTimeout(this.deleteCard2, this.moveTime, res);
		},
		deleteCard2: function(res){
			this.objx.objx2 = res.data.playerList[1][1];
			this.obj.dust = res.data.dustbox[1];
			setTimeout(this.move3, this.moveTime, res);
		},
		move3: function(res){
			this.objx.objx3 = res.data.playerList[2][0];
			this.objx.objx4 = res.data.playerList[3][2];
			setTimeout(this.deleteCard3, this.moveTime, res);
		},
		deleteCard3: function(res){
			this.objx.objx3 = res.data.playerList[2][1];
			this.obj.dust = res.data.dustbox[2];
			setTimeout(this.move4, this.moveTime, res);
		},
		move4: function(res){
			this.objx.objx4 = res.data.playerList[3][0];
			this.obj.obj1 = res.data.playerList[0][2];
			setTimeout(this.deleteCard4, this.moveTime, res);
		},
		deleteCard4: function(res){
			this.objx.objx4 = res.data.playerList[3][1];
			this.obj.dust = res.data.dustbox[3];
			if(res.data.finish){
				this.onemore(res);
			}
		},
		onemore: function(res) {
			swal({
				title: "結果発表",
				text: "結果は"+res.data.result+"位でした！！"+
					"\n\nもう一回遊びますか？",
				buttons: true,
			}).then((willDelete)=>{
				if(willDelete){
					location.href="http://localhost:8080/pullEyesWithOutDragon/Baba";
				}else{
					location.href="http://localhost:8080/pullEyesWithOutDragon/Start";
				}
			});
		},

		init: function(){
			this.obj.obj1.push(aaa)
			aaa++
			 let id =setTimeout(this.init, this.showTime);
				if(aaa > 12){
					clearTimeout(id);
					this.init2();
				}
		},
		init2: function(){
			this.obj.obj2.push(bbb)
			bbb++
			 let id2 =setTimeout(this.init2, this.showTime);
				if(bbb > 25){
					clearTimeout(id2);
					this.init3();
				}
		},
		init3: function(){
			this.obj.obj3.push(ccc)
			ccc++
			 let id3 =setTimeout(this.init3, this.showTime);
				if(ccc > 38){
					clearTimeout(id3);
					this.init4();
				}
		},
		init4: function(){
			this.obj.obj4.push(ddd)
			ddd++
			 let id4 =setTimeout(this.init4, this.showTime);
			if(ddd > 52){
		    	clearTimeout(id4);
		    	setTimeout(this.init5,2000);
		    }
		},
		init5: function(){
			this.obj.obj4.splice(e,1)
			e--
			let id5 =setTimeout(this.init5, this.showTime);
			if(e <0){
		    	clearTimeout(id5);
		    	audioElem = new Audio();
			      audioElem.src = "kaiba/nana.mp3";
			      audioElem.play();
		    	this.init6();
		    }
		},
		init6: function(){
			this.obj.obj3.splice(f,1)
			f--
			let id6 =setTimeout(this.init6, this.showTime);
			if(f <0){
		    	clearTimeout(id6);
		    	this.init7();
		    	}
		},
		init7: function(){
			this.obj.obj2.splice(g,1)
			g--
			let id7 =setTimeout(this.init7, this.showTime);
			if(g<0){
		    	clearTimeout(id7);
		    	this.init8();
		    }
		},
		init8: function(){
			this.obj.obj1.splice(h,1)
			h--
			let id8 =setTimeout(this.init8, this.showTime);
			if(h <0){
		    	clearTimeout(id8);
		    	setTimeout(this.init9,2000);
		    }
		},
		init9:function(){
			this.obj.obj1.push(this.sag.sag1[ff])
			ff++
			let id9 =setTimeout(this.init9, this.showTime);
			if(ff>=this.sag.sag1.length){
				console.log(ff>this.sag.sag1.length);
		    	clearTimeout(id9);
		    	audioElem = new Audio();
			      audioElem.src = "kaiba/ketueki.mp3";
			      audioElem.play();
		    	this.init10();
			}
		},
		init10:function(){
			this.objx.objx2.push(this.sag.sag2[jj])
			jj++
			let id10 =setTimeout(this.init10, this.showTime);
			if(jj>=this.sag.sag2.length){
				console.log(jj>13);
		    	clearTimeout(id10);
		    	this.init11();
			}
		},
		init11:function(){
			this.objx.objx3.push(this.sag.sag3[hh])
			hh++
			let id11 =setTimeout(this.init11, this.showTime);
			if(hh>=this.sag.sag3.length){
				console.log(hh>13);
		    	clearTimeout(id11);
		    	this.init12();
			}
		},
		init12:function(){
			this.objx.objx4.push(this.sag.sag4[ii])
			ii++
			let id12 =setTimeout(this.init12, this.showTime);
			if(ii>=this.sag.sag4.length){
		    	clearTimeout(id12);
		    	audioElem = new Audio();
			      audioElem.src = "kaiba/syouri.mp3";
			      audioElem.play();
			      setTimeout(this.init13,2000);
			}
		},
		init13:function(){
			this.cards = "cards2"
			this.player1 = "img/kaiba.png"
			this.player2 = "img/yuugi.png"
			this.player3 = "img/pega.png"
			this.player4 = "img/jou.jpg"
			this.isono = "img/isono.jpg"
			this.obj.obj1 = this.osinosinobu.osinosinobu1
			this.objx.objx2 = this.osinosinobu.osinosinobu2
			this.objx.objx3 = this.osinosinobu.osinosinobu3
			this.objx.objx4 = this.osinosinobu.osinosinobu4
			this.obj.dust = this.yuichan
		},
	}
})
