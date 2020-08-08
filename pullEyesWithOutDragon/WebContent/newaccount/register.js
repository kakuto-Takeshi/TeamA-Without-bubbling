

var app1 = new Vue({
	el: '#app1',
	data: {
		deth: "",
		user: null,
		password: null,
		mail: null,
		phoneNumber: null,
		age: null,
		sex: null
	},

	methods: {//メソッド
		red: function () {
			var element = document.getElementById("app1");
			element.style.backgroundColor = 'red';
			this.alert2();

		},
		alert1: function () {
			this.$swal({
				title: "忠告",
				text: "別れろ",
				icon: "warning",
				dangerMode: true,
			}).then((willDelete) => {
				this.red();
			});


		},
		alert2: function () {
			this.$swal({
				title: "忠告",
				text: "おままごとして楽しい？",
				icon: "warning",
				dangerMode: true,
			}).then((willDelete) => {
				this.alert3();
			});
		},
		alert3: function () {
			this.$swal({
				title: "忠告",
				text: "どうせいつか別れるんでしょう？",
				icon: "warning",
				dangerMode: true,
			}).then((willDelete) => {
				this.alert4();

			});
		},
		black: function () {
			var element = document.getElementById("app1");
			element.style.backgroundImage = "url(img/ti.jpg)";
			this.alert5();

		},
		alert4: function () {
			this.$swal({
				title: "忠告",
				text: "画面越しにお前の顔見えてるけど",
				icon: "warning",
				dangerMode: true,
			}).then((willDelete) => {

				this.black();
			});
		},
		alert5: function () {
			this.$swal({
				title: "忠告",
				text: "何わろてんねん",
				icon: "warning",
				dangerMode: true,
			}).then((willDelete) => {
				this.alert5();
			});
		},
		alert6: function () {
			this.$swal({
				title: "忠告",
				text: "こっち見んな",
				icon: "warning",
				dangerMode: true,
			}).then((willDelete) => {
				this.alert6();
			});
		},
		goodA: function () {
			this.$swal({
				title: "よろしい",
				text: "先に進みたまえ",
				icon: "success",
			})

		},
		touroku: function () {
			swal({
				title: "確認画面",
				text: '名前:' + this.user +
					"\nパスワード:" + this.password +
					"\nメールアドレス:" + this.mail +
					"\n電話番号:" + this.phoneNumber +
					"\n年齢:" + this.age +
					"\n性別:" + this.sex +
					"\nこの内容で登録しますか？",
				buttons: true,
				dangerMode: true,
			})
				.then((willDelete) => {
					if (willDelete) {
						document.milkyhomes.action = "http://localhost:8080/pullEyesWithOutDragon/Register";
						document.milkyhomes.method = "post";
						document.milkyhomes.submit();
					} else {

					}
				});
		},
	}//メソッド,



});
