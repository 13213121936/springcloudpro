﻿if(!window.XMLHttpRequest){window.XMLHttpRequest=function(){var a=["MSXML2.XMLHTTP.4.0","MSXML2.XMLHTTP.3.0","MSXML2.XMLHTTP.2.6","Msxml2.XMLHTTP","Microsoft.XMLHTTP","MSXML.XMLHTTP"];for(var c=0;c<a.length;c++){try{return new ActiveXObject(a[c])}catch(b){}}return null}}Function.createDelegate=function(a,b){return function(){return b.apply(a,arguments)}};if(typeof Autohome=="undefined"){var Autohome={}}if(!Autohome.exetend){Autohome.exetend=function(b,a){for(var c in a){b[c]=a[c]}return b}}Autohome.Ajax=function(a,c,b){this.options=Autohome.exetend({_xmlHttpRequest:new XMLHttpRequest(),url:"",body:"",backFun:function(){return null},method:"POST"},a||{});if(c&&b){this.options.body=c;this.options.backFun=b;this.options.url=a}this.send=function(){this.options._xmlHttpRequest.open(this.options.method,this.options.url,true);this.options._xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");this.options._xmlHttpRequest.onreadystatechange=Function.createDelegate(this,this._completed);this.options._xmlHttpRequest.send(this.FormatBody())};this.FormatBody=function(){var d="";for(var e in this.options.body){d+=e+"="+escape(this.options.body[e])+"&"}return d};this._completed=function(){if(this.options._xmlHttpRequest.readyState==4){this.options.backFun(this.options._xmlHttpRequest.responseText,this.options._xmlHttpRequest)}};this.send()};var geetest_challenge="";var geetest_seccode="";var geetest_validate="";var geetestresult=null;var geetecaptchaObj=null;var geetest_challenge2="";var geetest_seccode2="";var geetest_validate2="";var geetestresult2=null;var geetecaptchaObj2=null;(function(b){var c=function(d){b("#embed-submit").click(function(g){var f=b("#phoneno");if(f.value==""){setCursort(f);ErrorTip(f,"请填写手机号");return false}var h=d.getValidate();if(!h){b("#notice")[0].className="show";setTimeout(function(){b("#notice")[0].className="hide"},2000);g.preventDefault()}});d.appendTo("#embed-captcha");d.onReady(function(){b("#wait")[0].className="hide"});d.onSuccess(function(){geetecaptchaObj=d;geetestresult=d.getValidate();if(geetestresult){geetest_challenge=geetestresult.geetest_challenge;geetest_seccode=geetestresult.geetest_seccode;geetest_validate=geetestresult.geetest_validate;if(b("#aGetphoneno").hasClass("disabled")){b("#aGetphoneno").removeClass("disabled")}}})};var a=function(d){d.appendTo("#embed-captcha2");d.onReady(function(){b("#wait2")[0].className="hide"});d.onSuccess(function(){geetecaptchaObj2=d;geetestresult2=d.getValidate();if(geetestresult2){geetest_challenge2=geetestresult2.geetest_challenge;geetest_seccode2=geetestresult2.geetest_seccode;geetest_validate2=geetestresult2.geetest_validate;b("#notice2_err").html("").hide()}})};b.ajax({url:"/AccountApi/GetCaptcha?site=web&t="+(new Date()).getTime(),type:"get",dataType:"json",success:function(d){initGeetest({gt:d.gt,challenge:d.challenge,product:"embed",offline:!d.success,width:"100%",height:"38px"},c)}});b.ajax({url:"/AccountApi/GetCaptcha?site=web&t="+(new Date()).getTime(),type:"get",dataType:"json",success:function(d){initGeetest({gt:d.gt,challenge:d.challenge,product:"embed",offline:!d.success,width:"100%",height:"38px"},a)}});b("#phoneno").change(function(){if(geetecaptchaObj!=null){geetecaptchaObj.reset();geetecaptchaObj=null}})})(jQuery);var Msg={UserNameNull:"账号不能为空",PassWordNull:"密码不能为空",AccountError:"帐号或密码错误",ValidateCodeNull:"验证码不能为空",ValidateCodeLengthError:"验证码不正确",ValidFaile:"滑动验证失败，请重试",AdminError:"",Success:""};var onfocusClass="";var onblurClass="";var uc=0;var pc=0;var result1=false;var result2=false;var result3=false;var result4=false;function CheckUser(){$("#UserName").keyup(function(){uc=uc+1;var ul=0;var pl=0;if($("#UserName").val()!=undefined){ul=$("#UserName").val().length}if($("#PassWord").val()!=undefined){pl=$("#PassWord").val().length}setCookie("_SYLMM",uc+"-"+ul+"-"+pc+"-"+pl)});$("#PassWord").keyup(function(){pc=pc+1;var ul=0;var pl=0;if($("#UserName").val()!=undefined){ul=$("#UserName").val().length}if($("#PassWord").val()!=undefined){pl=$("#PassWord").val().length}setCookie("_SYLMM",uc+"-"+ul+"-"+pc+"-"+pl)});$("#PassWord").keypress(function(event){event=(event)?event:((window.event)?window.event:"");keyCode=event.keyCode?event.keyCode:(event.which?event.which:event.charCode);if(keyCode==13){$("#SubmitLogin").click()}});if($("#validateCode")){$("#validateCode").keypress(function(event){event=(event)?event:((window.event)?window.event:"");keyCode=event.keyCode?event.keyCode:(event.which?event.which:event.charCode);if(keyCode==13){$("#SubmitLogin").click()}})}$("#SubmitLogin").click(function(){var isCheck=0;var UserName=$("#UserName");if(UserName.val()==""){ErrorTip(UserName,"账号不能为空");setCursort(UserName);isCheck=1}else{ClearTip(UserName)}if(isCheck==0){var PassWord=$("#PassWord");if($.trim(PassWord.val())==""){ErrorTip(PassWord,"密码不能为空");isCheck=1;setCursort(PassWord)}else{if(PassWord.val().length<6||PassWord.val().length>40){ErrorTip(PassWord,"账号或密码错误");isCheck=1;setCursort(PassWord)}else{ClearTip(PassWord)}}}if(isCheck==0){if(geetecaptchaObj2==null){$("#notice2_err").html("请先进行滑动验证").show();isCheck=1}}var validateCodeValue="";if(isCheck==0&&$("#td1code").is(":visible")){var validateCode=$("#validateCode");validateCodeValue=validateCode.val();if(validateCodeValue==""){ErrorTip(validateCode,"验证码不能为空");setCursort(validateCode);isCheck=1}else{if(validateCodeValue.length!=4){ErrorTip(validateCode,"验证码不正确");setCursort(validateCode);isCheck=1}else{ClearTip(validateCode)}}}if(isCheck==0){var IsAuto=document.getElementById("IsAutoLogin").checked;$("#SubmitLogin").html("登录中..");new Autohome.Ajax({_self:this,url:"/Login/ValidIndex",body:{name:encodeURIComponent(UserName.val().replace(/\+/gi,"%2B")),pwd:hex_md5(PassWord.val()),validcode:validateCodeValue,isauto:IsAuto,type:"json",backurl:$("#backUrl").val(),url:$("#url").val(),geetest_challenge:geetest_challenge2,geetest_seccode:geetest_seccode2,geetest_validate:geetest_validate2},backFun:function(Text){resetgeetecaptcha();var o=eval("("+Text+")");if(o==undefined){alert("系统出了问题，请联系客服！");$("#SubmitLogin").html("登 录")}if(o.success==0){if(o.Msg=="Msg.AdminError"){window.location="/login/adminindex?isauto="+IsAuto+"&backurl="+$("#backUrl").val();return}if(o.Msg=="Msg.ChangePassword"){window.location="/login/UpdatePassWordIndex?isauto="+IsAuto+"&backurl="+$("#backUrl").val();return}if(o.Msg=="Msg.CheckAddressError"){window.location="/login/CheckAddressIndex?isauto="+IsAuto+"&backurl="+$("#backUrl").val();return}if(o.Msg=="Msg.ValidateCodeLengthError"){ErrorTip(validateCode,eval(o.Msg))}else{if(o.Msg=="Msg.ValidFaile"){$("#notice2_err").html(eval(o.Msg)).show()}else{ErrorTip(PassWord,eval(o.Msg))}}isAddCodeDiv(eval(o.Msg));if($("#validateCode")){}else{setCursort($("#UserName"))}$("#SubmitLogin").html("登 录")}else{if(o.Msg=="Msg.ChangePassword"){$("#backUrl").val("//i.autohome.com.cn/setting/password")}if(o.Msg=="Msg.NoBindMobile"){$("#backUrl").val("//"+document.domain+"/login/UserBindMobile?isauto="+IsAuto+"&bindbackurl="+encodeURIComponent($("#backUrl").val()))}if(o.Msg=="Msg.Ip3"){window.location.href=window.location.protocol+"//"+document.domain+"/Dubious/index?isauto="+IsAuto+"&bindbackurl="+encodeURIComponent($("#backUrl").val());return}JsLoad(o.LoginUrl,1,o);JsLoad(o.ssoAutohomeUrl,2,o);setCookie("_SYLMM","")}}})}});$("#phoneno").blur(function(){var phoneno=$("#phoneno");var reg=/^0?1[3|4|5|6|7|8|9][0-9]\d{8}$/;if(reg.test(phoneno.val())){$("#aGetphoneno").removeClass("disabled");$("#aGetphoneno").addClass("blue")}else{$("#aGetphoneno").removeClass("disabled");$("#aGetphoneno").removeClass("blue");$("#aGetphoneno").addClass("disabled")}});$("#SubmitPhoneLogin").click(function(){var phoneno=$("#phoneno");var code=$("#phonecode");if($.trim(phoneno.val())==""){ErrorTip(phoneno,"请填写手机号");setCursort(phoneno);return false}else{var reg=/^0?1[3|4|5|6|7|8|9][0-9]\d{8}$/;if(!reg.test(phoneno.val())){ErrorTip(phoneno,"手机号格式不正确");setCursort(phoneno);return false}else{ClearTip(phoneno)}}if(geetecaptchaObj==null){ErrorCodeTip("请先进行滑动验证");setCursort(code);return false}if($.trim(code.val())==""){ErrorCodeTip("请输入动态密码");setCursort(code);return false}var IsAuto=document.getElementById("IsMobileLogin").checked;$("#SubmitPhoneLogin a").html("登录中..");new Autohome.Ajax({_self:this,url:"/Login/VaildIndexPhoneChe168",body:{phoneno:phoneno.val(),phonecode:code.val()},backFun:function(Text){var o=eval("("+Text+")");if(o==undefined){alert("系统出了问题，请联系客服！");$("#SubmitPhoneLogin a").html("登录")}if(o.success==1){JsLoad(o.LoginUrl,1,o);JsLoad(o.ssoAutohomeUrl,2,o);setCookie("_SYLMM","")}else{if(o.success==2){msg.innerHTML=" <span>手机号尚未注册，请返回账号登录或者<a href='"+reurl+"'>注册新账号</a></span>";$("#SubmitPhoneLogin a").html("登录")}else{if(o.success==2010500||o.success==2010220){ErrorCodeTip(o.Msg)}else{ErrorTip(phoneno,o.Msg)}$("#SubmitPhoneLogin a").html("登录")}}}})})}function ClearTip(a){a.removeClass("error");a.parent().find("div").html("")}function ErrorTip(a,b){a.addClass("error");a.parent().find("div").html(b)}function ErrorCodeTip(a){$("#phonecode").addClass("error");$("#codeerrmsg").html(a);$("#codeerr").show()}function JsLoadCallBack(a){if(result2&&!result4){result4=true;JsLoad(a.loginUrlJiaJiaBX,3)}if(result1&&result2&&result3&&result4){setTimeout("Sccuess('"+$("#url").val()+"','"+$("#backUrl").val()+"','"+$("#backtopurl").val()+"')",0);result1=false;result2=false;result3=false;result4=false}}function JLoad(c){var d=document.createElement("script");var a=false;d.setAttribute("type","text/javascript");d.setAttribute("src",c);d.onload=d.onreadystatechange=function(){if(!a&&(!this.readyState||this.readyState=="loaded"||this.readyState=="complete")){a=true;try{d.parentNode.removeChild(d)}catch(b){}}};document.getElementsByTagName("head")[0].appendChild(d)}function JsLoad(d,c,g){var e=document.createElement("script");var a=false;e.setAttribute("type","text/javascript");e.setAttribute("src",d);e.id="tempscript"+c;e.onload=e.onreadystatechange=function(){if(!IsIE()){if(!a&&(document.readyState=="loaded"||document.readyState=="interactive"||document.readyState=="complete")){if(c==1){result1=true}else{if(c==2){result2=true}else{result3=true}}a=true;try{e.parentNode.removeChild(e)}catch(b){}JsLoadCallBack(g)}}else{if(!a&&(this.readyState=="loaded"||document.readyState=="interactive"||this.readyState=="complete")){if(c==1){result1=true}else{if(c==2){result2=true}else{result3=true}}a=true;try{e.parentNode.removeChild(e)}catch(b){}JsLoadCallBack(g)}}};document.getElementsByTagName("head")[0].appendChild(e);var f=0;return c}function IsIE(){if(navigator.appName==="Microsoft Internet Explorer"){return true}return false}function Sccuess(url,Url2,outUrl){new Autohome.Ajax({_self:this,url:"/login/GetBackUrl?backurl="+Url2+"&backtopurl="+outUrl,body:{},method:"GET",backFun:function(Text){var o=eval("("+Text+")");var backUrl="";var returnUrl="";if(o){backUrl=o.backurl}if(backUrl!=null&&backUrl!=undefined&&backUrl!=""){returnUrl=decodeURIComponent(backUrl)}else{if(url!=null&&url!=""){returnUrl=decodeURIComponent(url)}else{returnUrl=$("#hostUrl").val()}}window.location.href=returnUrl}})}function getCursortPosition(c){var b=0;if(document.selection){c.focus();var a=document.selection.createRange();a.moveStart("character",-c.val().length);b=a.text.length}else{if(c.selectionStart||c.selectionStart=="0"){b=c.selectionStart}}return(b)}function setCaretPosition(b,c){if(b.setSelectionRange){b.focus();b.setSelectionRange(c,c)}else{if(b.createTextRange){var a=b.createTextRange();a.collapse(true);a.moveEnd("character",c);a.moveStart("character",c);a.select()}}}function SetUserName(){var b=document.cookie.split("; ");name="clubUserShow";for(var c=0;c<b.length;c++){var a=b[c].split("=");if(name==a[0]){if(a.length>1){setCursort($("#PassWord"));var d=decodeURIComponent(a[1]).split("|");$("#UserName").val(d.length>5?d[3]:"");return}}}}function setCursort(b){var a=getCursortPosition(b);setCaretPosition(b,a)}CheckUser();function RequestFrs(){var d="fr";var b=document.location.href;var f=b.indexOf("?");var e=b.substr(f+1);var c=e.split("&");for(var a=0;a<c.length;a++){var g=c[a].split("=");if(g[0].toUpperCase()==d.toUpperCase()){return g[1]}}return""}var str=RequestFrs();if(str!="sina"){SetUserName()}function isAddCodeDiv(a){host=window.location.host;if(a!=null&&a.indexOf("验证码")>-1){$("#td1code").show();$("#ValidateCodeimg").click()}else{new Autohome.Ajax({_self:this,url:"/ValidateCode/AddValidateCode",body:{},backFun:function(b){if(b=="1"){$("#td1code").show();$("#ValidateCodeimg").click()}else{$("#td1code").hide()}$("#validateCode").val("")}})}}isAddCodeDiv();function setCookie(a,b){document.cookie=a+"="+escape(b)}if($("#phone-btn")!=undefined){$("#phone-btn").click(function(){$("#phone-login").attr("class","loginblock");$("#common-login").attr("class","loginblock fn-hide")});$("#common-btn").click(function(){$("#phone-login").attr("class","loginblock fn-hide");$("#common-login").attr("class","loginblock")})}var sendagainno=60;var isclick=false;$("#aGetphoneno").click(function(){if(isclick){return}isclick=true;if(geetecaptchaObj==null){var phonecode=$("#phonecode");ErrorTip(phonecode,"请先进行滑动验证");isclick=false;return false}var phoneno=$("#phoneno");if($.trim(phoneno.val())==""){ErrorTip(phoneno,"请填写手机号");setCursort(phoneno);isclick=false;return false}else{var reg=/^0?1[3|4|5|6|7|8|9][0-9]\d{8}$/;if(!reg.test(phoneno.val())){ErrorTip(phoneno,"手机号格式不正确");setCursort(phoneno);isclick=false;return false}else{ClearTip(phoneno)}}new Autohome.Ajax({_self:this,url:"/Login/SendPhoneNo",body:{phoneno:$("#phoneno").val(),geetest_challenge:geetest_challenge,geetest_seccode:geetest_seccode,geetest_validate:geetest_validate},backFun:function(Text){var o=eval("("+Text+")");if(o==undefined){alert("系统出了问题，请联系客服！");return}if(o.success==1){sendagin();return}if(o.Msg=="Msg.MobileNotExist"){ErrorCodeTip("手机号尚未注册，请返回账号登录或者<a href='"+reurl+"'>注册新账号</a>");setCursort(phoneno);isclick=false;return}if(o.Msg=="Msg.ValidCodeIpLimit"){ErrorCodeTip("验证码24小时内发送次数超限");setCursort(phoneno);isclick=false;return}if(o.Msg=="Msg.VailTimeOut"){ErrorCodeTip("请先进行滑动验证");setCursort(phoneno);isclick=false;return}if(o.Msg=="Msg.PhoneBlacklist"){ErrorTip(phoneno,"手机号已经加入黑名单，请返回账号登录");setCursort(phoneno);isclick=false;return}else{ErrorCodeTip("超出频率限制次数，请稍后再试");isclick=false;return}}});isclick=false});function changeAstate(){$("#aGetphoneno").html("发送验证码")}function sendagin(){if(sendagainno==0){changeAstate();sendagainno=60;isclick=false}else{isclick=true;$("#aGetphoneno").html("重新发送("+sendagainno+"s)");sendagainno--;setTimeout(function(){sendagin()},1000)}}function resetgeetecaptcha(){if(geetecaptchaObj!=null){geetecaptchaObj.reset();geetecaptchaObj=null}if(geetecaptchaObj2!=null){geetecaptchaObj2.reset();geetecaptchaObj2=null}}var hexcase=0;var b64pad="";var chrsz=8;function hex_md5(a){return binl2hex(core_md5(str2binl(a),a.length*chrsz))}function b64_md5(a){return binl2b64(core_md5(str2binl(a),a.length*chrsz))}function hex_hmac_md5(a,b){return binl2hex(core_hmac_md5(a,b))}function b64_hmac_md5(a,b){return binl2b64(core_hmac_md5(a,b))}function calcMD5(a){return binl2hex(core_md5(str2binl(a),a.length*chrsz))}function md5_vm_test(){return hex_md5("abc")=="900150983cd24fb0d6963f7d28e17f72"}function core_md5(p,k){p[k>>5]|=128<<((k)%32);p[(((k+64)>>>9)<<4)+14]=k;var o=1732584193;var n=-271733879;var m=-1732584194;var l=271733878;for(var g=0;g<p.length;g+=16){var j=o;var h=n;var f=m;var e=l;o=md5_ff(o,n,m,l,p[g+0],7,-680876936);l=md5_ff(l,o,n,m,p[g+1],12,-389564586);m=md5_ff(m,l,o,n,p[g+2],17,606105819);n=md5_ff(n,m,l,o,p[g+3],22,-1044525330);o=md5_ff(o,n,m,l,p[g+4],7,-176418897);l=md5_ff(l,o,n,m,p[g+5],12,1200080426);m=md5_ff(m,l,o,n,p[g+6],17,-1473231341);n=md5_ff(n,m,l,o,p[g+7],22,-45705983);o=md5_ff(o,n,m,l,p[g+8],7,1770035416);l=md5_ff(l,o,n,m,p[g+9],12,-1958414417);m=md5_ff(m,l,o,n,p[g+10],17,-42063);n=md5_ff(n,m,l,o,p[g+11],22,-1990404162);o=md5_ff(o,n,m,l,p[g+12],7,1804603682);l=md5_ff(l,o,n,m,p[g+13],12,-40341101);m=md5_ff(m,l,o,n,p[g+14],17,-1502002290);n=md5_ff(n,m,l,o,p[g+15],22,1236535329);o=md5_gg(o,n,m,l,p[g+1],5,-165796510);l=md5_gg(l,o,n,m,p[g+6],9,-1069501632);m=md5_gg(m,l,o,n,p[g+11],14,643717713);n=md5_gg(n,m,l,o,p[g+0],20,-373897302);o=md5_gg(o,n,m,l,p[g+5],5,-701558691);l=md5_gg(l,o,n,m,p[g+10],9,38016083);m=md5_gg(m,l,o,n,p[g+15],14,-660478335);n=md5_gg(n,m,l,o,p[g+4],20,-405537848);o=md5_gg(o,n,m,l,p[g+9],5,568446438);l=md5_gg(l,o,n,m,p[g+14],9,-1019803690);m=md5_gg(m,l,o,n,p[g+3],14,-187363961);n=md5_gg(n,m,l,o,p[g+8],20,1163531501);o=md5_gg(o,n,m,l,p[g+13],5,-1444681467);l=md5_gg(l,o,n,m,p[g+2],9,-51403784);m=md5_gg(m,l,o,n,p[g+7],14,1735328473);n=md5_gg(n,m,l,o,p[g+12],20,-1926607734);o=md5_hh(o,n,m,l,p[g+5],4,-378558);l=md5_hh(l,o,n,m,p[g+8],11,-2022574463);m=md5_hh(m,l,o,n,p[g+11],16,1839030562);n=md5_hh(n,m,l,o,p[g+14],23,-35309556);o=md5_hh(o,n,m,l,p[g+1],4,-1530992060);l=md5_hh(l,o,n,m,p[g+4],11,1272893353);m=md5_hh(m,l,o,n,p[g+7],16,-155497632);n=md5_hh(n,m,l,o,p[g+10],23,-1094730640);o=md5_hh(o,n,m,l,p[g+13],4,681279174);l=md5_hh(l,o,n,m,p[g+0],11,-358537222);m=md5_hh(m,l,o,n,p[g+3],16,-722521979);n=md5_hh(n,m,l,o,p[g+6],23,76029189);o=md5_hh(o,n,m,l,p[g+9],4,-640364487);l=md5_hh(l,o,n,m,p[g+12],11,-421815835);m=md5_hh(m,l,o,n,p[g+15],16,530742520);n=md5_hh(n,m,l,o,p[g+2],23,-995338651);o=md5_ii(o,n,m,l,p[g+0],6,-198630844);l=md5_ii(l,o,n,m,p[g+7],10,1126891415);m=md5_ii(m,l,o,n,p[g+14],15,-1416354905);n=md5_ii(n,m,l,o,p[g+5],21,-57434055);o=md5_ii(o,n,m,l,p[g+12],6,1700485571);l=md5_ii(l,o,n,m,p[g+3],10,-1894986606);m=md5_ii(m,l,o,n,p[g+10],15,-1051523);n=md5_ii(n,m,l,o,p[g+1],21,-2054922799);o=md5_ii(o,n,m,l,p[g+8],6,1873313359);l=md5_ii(l,o,n,m,p[g+15],10,-30611744);m=md5_ii(m,l,o,n,p[g+6],15,-1560198380);n=md5_ii(n,m,l,o,p[g+13],21,1309151649);o=md5_ii(o,n,m,l,p[g+4],6,-145523070);l=md5_ii(l,o,n,m,p[g+11],10,-1120210379);m=md5_ii(m,l,o,n,p[g+2],15,718787259);n=md5_ii(n,m,l,o,p[g+9],21,-343485551);o=safe_add(o,j);n=safe_add(n,h);m=safe_add(m,f);l=safe_add(l,e)}return Array(o,n,m,l)}function md5_cmn(h,e,d,c,g,f){return safe_add(bit_rol(safe_add(safe_add(e,h),safe_add(c,f)),g),d)}function md5_ff(g,f,k,j,e,i,h){return md5_cmn((f&k)|((~f)&j),g,f,e,i,h)}function md5_gg(g,f,k,j,e,i,h){return md5_cmn((f&j)|(k&(~j)),g,f,e,i,h)}function md5_hh(g,f,k,j,e,i,h){return md5_cmn(f^k^j,g,f,e,i,h)}function md5_ii(g,f,k,j,e,i,h){return md5_cmn(k^(f|(~j)),g,f,e,i,h)}function core_hmac_md5(c,f){var e=str2binl(c);if(e.length>16){e=core_md5(e,c.length*chrsz)}var a=Array(16),d=Array(16);for(var b=0;b<16;b++){a[b]=e[b]^909522486;d[b]=e[b]^1549556828}var g=core_md5(a.concat(str2binl(f)),512+f.length*chrsz);return core_md5(d.concat(g),512+128)}function safe_add(a,d){var c=(a&65535)+(d&65535);var b=(a>>16)+(d>>16)+(c>>16);return(b<<16)|(c&65535)}function bit_rol(a,b){return(a<<b)|(a>>>(32-b))}function str2binl(d){var c=Array();var a=(1<<chrsz)-1;for(var b=0;b<d.length*chrsz;b+=chrsz){c[b>>5]|=(d.charCodeAt(b/chrsz)&a)<<(b%32)}return c}function binl2hex(c){var b=hexcase?"0123456789ABCDEF":"0123456789abcdef";var d="";for(var a=0;a<c.length*4;a++){d+=b.charAt((c[a>>2]>>((a%4)*8+4))&15)+b.charAt((c[a>>2]>>((a%4)*8))&15)}return d}function binl2b64(d){var c="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";var f="";for(var b=0;b<d.length*4;b+=3){var e=(((d[b>>2]>>8*(b%4))&255)<<16)|(((d[b+1>>2]>>8*((b+1)%4))&255)<<8)|((d[b+2>>2]>>8*((b+2)%4))&255);for(var a=0;a<4;a++){if(b*8+a*6>d.length*32){f+=b64pad}else{f+=c.charAt((e>>6*(3-a))&63)}}}return f}var base64EncodeChars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";var base64DecodeChars=new Array(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,62,-1,-1,-1,63,52,53,54,55,56,57,58,59,60,61,-1,-1,-1,-1,-1,-1,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,-1,-1,-1,-1,-1,-1,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,-1,-1,-1,-1,-1);function base64encode(g){var c,e,a;var f,d,b;a=g.length;e=0;c="";while(e<a){f=g.charCodeAt(e++)&255;if(e==a){c+=base64EncodeChars.charAt(f>>2);c+=base64EncodeChars.charAt((f&3)<<4);c+="==";break}d=g.charCodeAt(e++);if(e==a){c+=base64EncodeChars.charAt(f>>2);c+=base64EncodeChars.charAt(((f&3)<<4)|((d&240)>>4));c+=base64EncodeChars.charAt((d&15)<<2);c+="=";break}b=g.charCodeAt(e++);c+=base64EncodeChars.charAt(f>>2);c+=base64EncodeChars.charAt(((f&3)<<4)|((d&240)>>4));c+=base64EncodeChars.charAt(((d&15)<<2)|((b&192)>>6));c+=base64EncodeChars.charAt(b&63)}return c}function base64decode(h){var g,f,d,b;var e,a,c;a=h.length;e=0;c="";while(e<a){do{g=base64DecodeChars[h.charCodeAt(e++)&255]}while(e<a&&g==-1);if(g==-1){break}do{f=base64DecodeChars[h.charCodeAt(e++)&255]}while(e<a&&f==-1);if(f==-1){break}c+=String.fromCharCode((g<<2)|((f&48)>>4));do{d=h.charCodeAt(e++)&255;if(d==61){return c}d=base64DecodeChars[d]}while(e<a&&d==-1);if(d==-1){break}c+=String.fromCharCode(((f&15)<<4)|((d&60)>>2));do{b=h.charCodeAt(e++)&255;if(b==61){return c}b=base64DecodeChars[b]}while(e<a&&b==-1);if(b==-1){break}c+=String.fromCharCode(((d&3)<<6)|b)}return c}function utf16to8(e){var b,d,a,f;b="";a=e.length;for(d=0;d<a;d++){f=e.charCodeAt(d);if((f>=1)&&(f<=127)){b+=e.charAt(d)}else{if(f>2047){b+=String.fromCharCode(224|((f>>12)&15));b+=String.fromCharCode(128|((f>>6)&63));b+=String.fromCharCode(128|((f>>0)&63))}else{b+=String.fromCharCode(192|((f>>6)&31));b+=String.fromCharCode(128|((f>>0)&63))}}}return b}function utf8to16(g){var b,e,a,h;var f,d;b="";a=g.length;e=0;while(e<a){h=g.charCodeAt(e++);switch(h>>4){case 0:case 1:case 2:case 3:case 4:case 5:case 6:case 7:b+=g.charAt(e-1);break;case 12:case 13:f=g.charCodeAt(e++);b+=String.fromCharCode(((h&31)<<6)|(f&63));break;case 14:f=g.charCodeAt(e++);d=g.charCodeAt(e++);b+=String.fromCharCode(((h&15)<<12)|((f&63)<<6)|((d&63)<<0));break}}return b}(function(a,c,b){if(typeof module!=="undefined"&&module.exports){module.exports=b()}else{if(typeof define==="function"&&define.amd){define(b)}else{c[a]=b()}}})("AutoPc",this,function(){var a=function(b){var c,d;c=Array.prototype.forEach;d=Array.prototype.map;this.each=function(k,j,h){if(k===null){return}if(c&&k.forEach===c){k.forEach(j,h)}else{if(k.length===+k.length){for(var g=0,e=k.length;g<e;g++){if(j.call(h,k[g],g,k)==={}){return}}}else{for(var f in k){if(k.hasOwnProperty(f)){if(j.call(h,k[f],f,k)==={}){return}}}}}};this.map=function(h,g,f){var e=[];if(h==null){return e}if(d&&h.map===d){return h.map(g,f)}this.each(h,function(k,i,j){e[e.length]=g.call(f,k,i,j)});return e};if(typeof b=="object"){this.hasher=b.hasher;this.screen_resolution=b.screen_resolution;this.canvas=b.canvas;this.ie_activex=b.ie_activex}else{if(typeof b=="function"){this.hasher=b}}};a.prototype={get:function(){var c=[];c.push(navigator.userAgent);c.push(navigator.language);c.push(screen.colorDepth);if(this.screen_resolution){var b=this.getScreenResolution();if(typeof b!=="undefined"){c.push(this.getScreenResolution().join("x"))}}c.push(new Date().getTimezoneOffset());c.push(this.hasSessionStorage());c.push(this.hasLocalStorage());c.push(!!window.indexedDB);if(document.body){c.push(typeof(document.body.addBehavior))}else{c.push(typeof undefined)}c.push(typeof(window.openDatabase));c.push(navigator.cpuClass);c.push(navigator.platform);c.push(navigator.doNotTrack);c.push(this.getPluginsString());if(this.canvas&&this.isCanvasSupported()){c.push(this.getCanvasFingerprint())}if(this.hasher){return this.hasher(c.join("###"),31)}else{return this.murmurhash3_32_gc(c.join("###"),31)}},murmurhash3_32_gc:function(j,f){var k,l,h,b,e,c,g,d;k=j.length&3;l=j.length-k;h=f;e=3432918353;c=461845907;d=0;while(d<l){g=((j.charCodeAt(d)&255))|((j.charCodeAt(++d)&255)<<8)|((j.charCodeAt(++d)&255)<<16)|((j.charCodeAt(++d)&255)<<24);++d;g=((((g&65535)*e)+((((g>>>16)*e)&65535)<<16)))&4294967295;g=(g<<15)|(g>>>17);g=((((g&65535)*c)+((((g>>>16)*c)&65535)<<16)))&4294967295;h^=g;h=(h<<13)|(h>>>19);b=((((h&65535)*5)+((((h>>>16)*5)&65535)<<16)))&4294967295;h=(((b&65535)+27492)+((((b>>>16)+58964)&65535)<<16))}g=0;switch(k){case 3:g^=(j.charCodeAt(d+2)&255)<<16;case 2:g^=(j.charCodeAt(d+1)&255)<<8;case 1:g^=(j.charCodeAt(d)&255);g=(((g&65535)*e)+((((g>>>16)*e)&65535)<<16))&4294967295;g=(g<<15)|(g>>>17);g=(((g&65535)*c)+((((g>>>16)*c)&65535)<<16))&4294967295;h^=g}h^=j.length;h^=h>>>16;h=(((h&65535)*2246822507)+((((h>>>16)*2246822507)&65535)<<16))&4294967295;h^=h>>>13;h=((((h&65535)*3266489909)+((((h>>>16)*3266489909)&65535)<<16)))&4294967295;h^=h>>>16;return h>>>0},hasLocalStorage:function(){try{return !!window.localStorage}catch(b){return true}},hasSessionStorage:function(){try{return !!window.sessionStorage}catch(b){return true}},isCanvasSupported:function(){var b=document.createElement("canvas");return !!(b.getContext&&b.getContext("2d"))},isIE:function(){if(navigator.appName==="Microsoft Internet Explorer"){return true}else{if(navigator.appName==="Netscape"&&/Trident/.test(navigator.userAgent)){return true}}return false},getPluginsString:function(){if(this.isIE()){return this.getIEPluginsString()}else{return this.getRegularPluginsString()}},getRegularPluginsString:function(){return this.map(navigator.plugins,function(c){var b=this.map(c,function(d){return[d.type,d.suffixes].join("~")}).join(",");return[c.name,c.description,b].join("::")},this).join(";")},getIEPluginsString:function(){if(window.ActiveXObject){var b=["ShockwaveFlash.ShockwaveFlash","AcroPDF.PDF","PDF.PdfCtrl","QuickTime.QuickTime","rmocx.RealPlayer G2 Control","rmocx.RealPlayer G2 Control.1","RealPlayer.RealPlayer(tm) ActiveX Control (32-bit)","RealVideo.RealVideo(tm) ActiveX Control (32-bit)","RealPlayer","SWCtl.SWCtl","WMPlayer.OCX","AgControl.AgControl","Skype.Detection"];return this.map(b,function(c){try{var d=new ActiveXObject(c);if(d!=null&&d!=undefined&&c=="ShockwaveFlash.ShockwaveFlash"){return c+d.GetVariable("$version")}return c}catch(f){return null}}).join(";")}else{return""}},getScreenResolution:function(){return[screen.height,screen.width]},getCanvasFingerprint:function(){var d=document.createElement("canvas");var c=d.getContext("2d");var b="http://valve.github.io";try{c.textBaseline="top";c.font="14px 'Arial'";c.textBaseline="alphabetic";c.fillStyle="#f60";c.fillRect(125,1,62,20);c.fillStyle="#069";c.fillText(b,2,15);c.fillStyle="rgba(102, 204, 0, 0.7)";c.fillText(b,4,17)}catch(f){}return d.toDataURL()}};return a});function setCookie(a,c){var b=30;var d=new Date();d.setTime(d.getTime()+b*24*60*60*1000);document.cookie=a+"="+escape(c)}window.onload=function(){var a=new AutoPc({canvas:true,screen_resolution:true}).get();setCookie("_ILMD",a)};