package com.bthuillier.vdm

import org.scalatest.{ Matchers, WordSpec }
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.server._
import Directives._
import org.jsoup.Jsoup

class VDMParserSpec extends WordSpec with Matchers with VDMHtml {

  "The parser" should {

    "correctly parse VDM html" in {
      val document = Jsoup.parse(html)
      val posts = VDMParser.parseDocument(document)
      posts should have size(13)
    }
  }
}

trait VDMHtml {

  val html: String = """<!DOCTYPE html>
  <html lang="fr">
  <head>
  	<meta name="title" content="Vie de merde : Vos histoires de la vie quotidienne" />
  	<meta name="description" content="Ma vie c'est de la merde, et je vous emmerde. Partagez vos petits malheurs et drôles d'histoires de la vie quotidienne sur VDM." />
  	<meta charset="utf-8" />
  	<link rel="shortcut icon" href="http://cdn6.viedemerde.fr/fmylife/images/favicon.fr.ico" />
  	<meta name="author" content="Maxime Valette, Guillaume Passaglia" />
  	<link rel="image_src" href="http://cdn6.viedemerde.fr/fmylife/images/logo200.fr.jpg?new" />
  	<link rel="alternate" type="application/rss+xml" title="Suivre les VDM" href="/feeds/articles" />
  	<link rel="alternate" type="application/rss+xml" title="Suivre le blog VDM" href="/feeds/blog" />
  	<link rel="alternate" type="application/rss+xml" title="Suivre les commentaires VDM" href="/feeds/comments" />
  	<link rel="alternate" type="application/rss+xml" title="Suivre les VDM illustrées" href="/feeds/illustrated" />
  	<title>Vie de merde : Vos histoires de la vie quotidienne</title>
  	<meta property="fb:app_id" content="360818827295638" />
  	<meta property="og:title" content="Vie de merde : Vos histoires de la vie quotidienne"/>
  	<meta property="og:type" content="article"/>
  	<meta property="og:url" content="http://www.viedemerde.fr/?page=0"/>
  	<meta property="og:image" content="http://cdn7.viedemerde.fr/fmylife/images/logo200.fr.jpg?new" />
  	<meta name="twitter:image" content="http://cdn7.viedemerde.fr/fmylife/images/logo200.fr.jpg?new">
  	<meta property="og:site_name" content="Vie de merde"/>
  	<meta property="og:description" content="Ma vie c'est de la merde, et je vous emmerde. Partagez vos petits malheurs et drôles d'histoires de la vie quotidienne sur VDM."/>
  	<meta name="twitter:card" content="summary">
  	<meta name="twitter:url" content="http://www.viedemerde.fr/?page=0">
  	<meta name="twitter:title" content="Vie de merde : Vos histoires de la vie quotidienne">
  	<meta name="twitter:description" content="Ma vie c'est de la merde, et je vous emmerde. Partagez vos petits malheurs et drôles d'histoires de la vie quotidienne sur VDM.">
  	<meta name="twitter:site" content="@viedemerde">
  	<link rel="stylesheet" media="screen" type="text/css" href="http://cdn7.viedemerde.fr/fmylife/css/compiled/public.general.css" />
  	<link href="https://plus.google.com/109820933781607194302/" rel="publisher" />

  <script type='text/javascript'>
  //<!-- ORANGE SCRIPT
            var ezMarkerType = 'viedemerde.fr';
            var ezC = ["d:NomEditeur"];
            (function(){
  			  	var s = document.createElement("script");
  			  	s.type = "text/javascript";
  			  	s.src = document.location.protocol + "//orange.ezakus.net/marker/";
  			  	s.async = true;
  			  	var head = document.head || document.getElementsByTagName("head")[0];
  			  	head.appendChild(s);
  		   })();
  //-->
  </script>
  	<script type="text/javascript">
  		var _gaq = _gaq || [];
  		_gaq.push(['_setAccount', 'UA-2538950-3']);
  		_gaq.push(['_setDomainName', '.viedemerde.fr']);
  		_gaq.push(['._setCustomVar', 1, 'user-type', 'visitor', 2]);
  		_gaq.push(['_trackPageview']);

  		(function() {
  			var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
  			ga.src = ('https:' == document.location.protocol ? 'https://cdn.betacie.com' : 'http://cdn6.betacie.net') + '/ga.js';
  			var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  		})();
  	</script>
  </head>
  <body id="top">

  <p class="msg">Vous ne voyez pas votre site habituel ? AdBlock a décidé de bloquer la majeure partie de notre site. Désactivez votre extension AdBlock sur le site viedemerde.fr pour retrouver notre site en version originale. Nous n'affichons que 3 bannières de publicités sur nos pages et jamais de format intrusif (pop-up, interstitiels, etc.). Merci à vous.<br><br>Pour toute question, n’hésitez pas à nous contacter : <a href="mailto:support@viedemerde.fr">support@viedemerde.fr</a><br><br><br><br><br><br><br><br></p>


  <div id="fb-root"></div><script>
    (function(d){
      var js, id = 'facebook-jssdk'; if (d.getElementById(id)) {return;}
      js = d.createElement('script'); js.id = id; js.async = true;
      js.src = "//connect.facebook.net/fr_FR/all.js";
      d.getElementsByTagName('head')[0].appendChild(js);
    }(document));
    </script>
  <div class="popup_container"></div>

  <div id="background">

  <div id="topbar">
  	<div id="contenttop">
  		<div id="title">
              <a href="/" title="Accueil" accesskey="1" class="toplogo_fr"></a>		</div>

  		<div class="menu">
  			<h1 class=""><a href="/faq" accesskey="2">FAQ</a></h1><h1 class=""><a href="/applications/officielles" accesskey="3">Applications</a><div class="submenu_container"><div class="submenu"><ul><li><a href="/applications/officielles#a_156">VDM pour iPhone et iPad</a></li><li><a href="/applications/officielles#a_1">VDM pour Android</a></li><li><a href="/applications/officielles#a_162">VDM pour WP7</a></li><li><a href="/applications/officielles#a_141">VDM pour BlackBerry</a></li><li><a href="/applications/officielles#a_148">VDM pour Samsung Wave</a></li><li><a href="/applications/autres">Autres applications</a></li><li><a href="/api/accueil">Utiliser l'API VDM</a></li></ul></div></div></h1><h1 class=""><a href="/tops/favorite/semaine" accesskey="4">Top</a><div class="submenu_container"><div class="submenu"><ul><li><a href="/tops/top/semaine">Le top</a></li><li><a href="/tops/flop/semaine">Le flop</a></li><li><a href="/tops/favorite/semaine">Classer par favoris</a></li><li><a href="/tops/comment/semaine">Classer par commentaires</a></li></ul></div></div></h1><h1 class=""><a href="/aleatoire" accesskey="5">VDM aléatoire</a></h1><h1 class=""><a href="/boutique" accesskey="6">Boutique</a><div class="submenu_container"><div class="submenu"><ul><li><a href="/boutique#categ1">Les accessoires VDM</a></li><li><a href="/boutique#categ3">Les livres VDM</a></li></ul></div></div></h1><h1 class="submit "><a class="submit" onclick="submitToggle()" href="javascript:;" accesskey="7">Soumettez votre VDM</a></h1><h1 class="moderate "><a href="/moderation" accesskey="8">Modérez les VDM</a></h1><h1 id="user"><a href="" class="t_user" accesskey="9"></a><div class="submenu_container" id="user_submenu"><div class="submenu"><ul><li><div class="loginform"><form name="login" action="https://www.viedemerde.fr/apps/account_login.php" method="post"><input type="text" name="login" value="" placeholder="Pseudo" /><input type="password" name="pass" value="" placeholder="Mot de passe" /><input type="submit" value="Connexion" id="submit_connexion" /></form></div></li><li><a href="/inscription" class="bold">Créer un compte VDM</a></li><li><a href="/motdepasse">Mot de passe oublié ?</a></li></ul></div></div><div class="badge" style="display: none;"></div></h1>		</div>
  		<form action="/apps/search.php" method="post" id="recherche_haut">
  			<input type="hidden" name="type" value="article" />
  			<input type="hidden" name="from" value="top" />
              <input type="hidden" name="option" value="precise">
  			<input type="text" name="texte" id="mot" placeholder="Recherche" />
  		</form>
  	</div>
  </div>

  <div id="content">

  <div class="wrapper">

  <div id="submit" class="post">
  	<h3>Soumettez votre vie de merde</h3>


  	<ul>
  		<li>- <strong>Rappel du concept :</strong> Une anecdote qui commence par "Aujourd'hui" et qui se termine par "VDM".</li>
  		<li>- <b>Attention :</b> Une anecdote écrite en SMS ou comportant trop de fautes d'orthographe est toujours refusée.</li>
  		<li class="red">- N'utilisez pas cet espace pour des discussions, de la publicité ou pour tout autre texte n'étant pas une VDM.</li>	</ul>


  	<form method="post" class="submit_form" action="/ajax/articles/submit.php">
  		<fieldset>
  			<div class="input_auteur">Votre pseudo : <input type="text" name="auteur" value="" /></div>			<div class="input_cat">Catégorie : <select name="cat" id="cat" >
  				<option value="">Choisir</option>
  				<option value="amour">Amour</option>
  <option value="animaux">Animaux</option>
  <option value="argent">Argent</option>
  <option value="enfants">Enfants</option>
  <option value="travail">Travail</option>
  <option value="sante">Santé</option>
  <option value="sexe">Sexe</option>
  <option value="inclassable">Inclassable</option>
  			</select></div>

  			<div class="input_sexe">Sexe :  <select name="sexe">
  				<option value="none">Choisir</option>
  				<option value="homme">Homme</option>
  				<option value="femme">Femme</option>
  			</select></div>

  			<textarea id="update" name="content" rows="6" onkeyup="cut(this);"></textarea>

  			                <div class="input_mail"><a href="javascript:;" onclick="displayMail();">Être prévenu par e-mail ?</a></div>

  			<div class="ok"><div id="compteur"></div> <input type="submit" name="ok" value="Balance la sauce"/></div>
  			<input type="text" id="firstname" value="" name="firstname" />
  					</fieldset>
  	</form>

  </div>

  <!-- <div class="cf"></div> !-->

  <div id="ad_leaderboard"><div class="leaderboard"><div class="" id="d40d76fbfef25f3f68b63f5e2b627220" data-name="d40d76fbfef25f3f68b63f5e2b627220" data-placeholder="http://telegram.viedemerde.fr/exosmic/wysox/lootefuleur" style="position: relative;"><script type="text/javascript">var d=document.location;var t=new Date;document.write("<script src='//cdn.dekalee.net/serve/17.js?p="+encodeURIComponent(d.pathname)+"&s="+encodeURIComponent(d.search)+"&t="+t.getTime()+"&ip=88.190.2.209&uid=789983138'>\x3C/script>")</script></div></div></div><div id="top_message"></div><div class="post article" id="8647640"><p><a href="/sexe/8647640" class="fmllink">Aujourd'hui, je confie à une amie mariée que, traversant une période difficile avec mon conjoint, je le trompe avec un ami.</a><a href="/sexe/8647640" class="fmllink"> Elle est outrée : mon amant est aussi le sien.</a><a href="/sexe/8647640" class="fmllink"> VDM</a></p><div class="date"><div class="left_part"><a href="/sexe/8647640" id="article_8647640" name="/resume/article/8647640" class="jTip">#8647640</a><br /><span class="dyn-comments">0 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8647640"><a href="javascript:;" onclick="vote('8647640','791','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">791</span>)</span> - <span class="dyn-vote-t" id="votebf8647640"><a href="javascript:;" onclick="vote('8647640','7461','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">7461</span>)</span></p><p>Le 30/11/2015 à 10:15 - <a class="liencat" href="/sexe">sexe</a> - par jessica93 (<a href="/genre/femme" class="light">femme</a>)</p></div></div><div class="more" id="more8647640"><div class="fb-like" data-href="http://www.viedemerde.fr/sexe/8647640" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/sexe/8647640#new','8647640');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="post article" id="8647621"><p><a href="/amour/8647621" class="fmllink">Aujourd'hui, j'ai rêvé qu'Isabella, récemment devenue stérile suite à une operation, me demandait d'être mère porteuse pour elle.</a><a href="/amour/8647621" class="fmllink"> Isabella, ma chienne.</a><a href="/amour/8647621" class="fmllink"> Oui, la solitude me pèse.</a><a href="/amour/8647621" class="fmllink"> VDM</a></p><div class="date"><div class="left_part"><a href="/amour/8647621" id="article_8647621" name="/resume/article/8647621" class="jTip">#8647621</a><br /><span class="dyn-comments">38 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8647621"><a href="javascript:;" onclick="vote('8647621','963','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">963</span>)</span> - <span class="dyn-vote-t" id="votebf8647621"><a href="javascript:;" onclick="vote('8647621','1689','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">1689</span>)</span></p><p>Le 30/11/2015 à 08:47 - <a class="liencat" href="/amour">amour</a> - par Anonyme (<a href="/genre/femme" class="light">femme</a>)</p></div></div><div class="more" id="more8647621"><div class="fb-like" data-href="http://www.viedemerde.fr/amour/8647621" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/amour/8647621#new','8647621');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="post article" id="8647610"><p><a href="/travail/8647610" class="fmllink">Aujourd'hui, c'est la COP21.</a><a href="/travail/8647610" class="fmllink"> Je me lève 2 h plus tôt, à 5 h 00 du matin pour éviter les bouchons sur la route.</a><a href="/travail/8647610" class="fmllink"> À 8 h 00, contrairement à d'habitude (et à ce qui était annoncé) le trafic est quasi inexistant, et je suis tout seul au bureau depuis 2 h.</a><a href="/travail/8647610" class="fmllink"> Je m'ennuie.</a><a href="/travail/8647610" class="fmllink"> VDM</a></p><div class="date"><div class="left_part"><a href="/travail/8647610" id="article_8647610" name="/resume/article/8647610" class="jTip">#8647610</a><br /><span class="dyn-comments">36 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8647610"><a href="javascript:;" onclick="vote('8647610','1213','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">1213</span>)</span> - <span class="dyn-vote-t" id="votebf8647610"><a href="javascript:;" onclick="vote('8647610','136','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">136</span>)</span></p><p>Le 30/11/2015 à 07:47 - <a class="liencat" href="/travail">travail</a> - par MonZon </p></div></div><div class="more" id="more8647610"><div class="fb-like" data-href="http://www.viedemerde.fr/travail/8647610" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/travail/8647610#new','8647610');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="post article" id="8647601"><p><a href="/inclassable/8647601" class="fmllink">Aujourd'hui, je vais rendre visite à mes parents.</a><a href="/inclassable/8647601" class="fmllink"> Ma mère : &quot;Quoi, tu ne mets pas encore d'antirides à 34 ans ?&quot; Mon père : &quot;Elle n'en a pas besoin… (petit sourire de contentement)… y'a pas de rides sur un ballon !&quot; Merci maman.</a><a href="/inclassable/8647601" class="fmllink"> Merci papa.</a><a href="/inclassable/8647601" class="fmllink"> VDM</a></p><div class="date"><div class="left_part"><a href="/inclassable/8647601" id="article_8647601" name="/resume/article/8647601" class="jTip">#8647601</a><br /><span class="dyn-comments">34 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8647601"><a href="javascript:;" onclick="vote('8647601','12275','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">12275</span>)</span> - <span class="dyn-vote-t" id="votebf8647601"><a href="javascript:;" onclick="vote('8647601','983','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">983</span>)</span></p><p>Le 30/11/2015 à 07:15 - <a class="liencat" href="/inclassable">inclassable</a> - par Lulu26 (<a href="/genre/femme" class="light">femme</a>)</p></div></div><div class="more" id="more8647601"><div class="fb-like" data-href="http://www.viedemerde.fr/inclassable/8647601" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/inclassable/8647601#new','8647601');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="post article" id="8647400"><p><a href="/enfants/8647400" class="fmllink">Aujourd'hui, je suis réveillé par un énorme bruit provenant du garage.</a><a href="/enfants/8647400" class="fmllink"> Mon fils de 16 ans a tenté d'emprunter ma voiture pour aller voir sa copine d'internet qu'il n'a jamais vu.</a><a href="/enfants/8647400" class="fmllink"> Elle habite à 750 km et il n'a pas le permis.</a><a href="/enfants/8647400" class="fmllink"> Il a planté la voiture.</a><a href="/enfants/8647400" class="fmllink"> VDM</a></p><div class="date"><div class="left_part"><a href="/enfants/8647400" id="article_8647400" name="/resume/article/8647400" class="jTip">#8647400</a><br /><span class="dyn-comments">76 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8647400"><a href="javascript:;" onclick="vote('8647400','1415','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">1415</span>)</span> - <span class="dyn-vote-t" id="votebf8647400"><a href="javascript:;" onclick="vote('8647400','2233','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">2233</span>)</span></p><p>Le 29/11/2015 à 18:47 - <a class="liencat" href="/enfants">enfants</a> - par Anonyme </p></div></div><div class="more" id="more8647400"><div class="fb-like" data-href="http://www.viedemerde.fr/enfants/8647400" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/enfants/8647400#new','8647400');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="topcomment"><p>↑ <strong>Commentaire de jaieuchaud :</strong> 750 kilomètres pour tomber sur Roger 45 ans poilu comme un ours... Son incompétence à conduire l'a sauvé d'un triste destin.</p><p class="right"><a href="/enfants/8647400">Voir tous les commentaires →</a></p></div><div class="post article" id="8647354"><p><a href="/inclassable/8647354" class="fmllink">Aujourd'hui, je décide, comme d'habitude, de me mettre de l'anti-cerne avant d'entamer ma journée.</a><a href="/inclassable/8647354" class="fmllink"> Me demandant pourquoi les gens souriaient autant en me voyant, je décide de sortir le petit miroir placé dans ma trousse.</a><a href="/inclassable/8647354" class="fmllink"> Le rouge à lèvres sous mes yeux me va à merveille.</a><a href="/inclassable/8647354" class="fmllink"> VDM</a></p><div class="date"><div class="left_part"><a href="/inclassable/8647354" id="article_8647354" name="/resume/article/8647354" class="jTip">#8647354</a><br /><span class="dyn-comments">90 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8647354"><a href="javascript:;" onclick="vote('8647354','31502','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">31502</span>)</span> - <span class="dyn-vote-t" id="votebf8647354"><a href="javascript:;" onclick="vote('8647354','5174','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">5174</span>)</span></p><p>Le 29/11/2015 à 16:38 - <a class="liencat" href="/inclassable">inclassable</a> - par IzamiTomoe (<a href="/genre/femme" class="light">femme</a>)</p></div></div><div class="more" id="more8647354"><div class="fb-like" data-href="http://www.viedemerde.fr/inclassable/8647354" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/inclassable/8647354#new','8647354');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="topcomment"><p>↑ <strong>Commentaire de AnonymeVDM00145 :</strong> Stop à l'anti-cerne, je crois qu'il faut dormir maintenant ..</p><p class="right"><a href="/inclassable/8647354">Voir tous les commentaires →</a></p></div><div class="post article" id="8647334"><p><a href="/sexe/8647334" class="fmllink">Aujourd'hui, je prends le métro à l'heure de pointe avec mon petit frère de 7 ans, qui joue sur mon téléphone.</a><a href="/sexe/8647334" class="fmllink"> Tout d'un coup, il me dit : ''Tu as un SMS de Marie qui te demande si tu veux faire l'amour ce soir.</a><a href="/sexe/8647334" class="fmllink">'' VDM</a></p><div class="date"><div class="left_part"><a href="/sexe/8647334" id="article_8647334" name="/resume/article/8647334" class="jTip">#8647334</a><br /><span class="dyn-comments">78 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8647334"><a href="javascript:;" onclick="vote('8647334','27281','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">27281</span>)</span> - <span class="dyn-vote-t" id="votebf8647334"><a href="javascript:;" onclick="vote('8647334','3826','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">3826</span>)</span></p><p>Le 29/11/2015 à 15:33 - <a class="liencat" href="/sexe">sexe</a> - par Anoninimous </p></div></div><div class="more" id="more8647334"><div class="fb-like" data-href="http://www.viedemerde.fr/sexe/8647334" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/sexe/8647334#new','8647334');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="topcomment"><p>↑ <strong>Commentaire de Le_thiecos :</strong> ahhhhhh l'innocence enfantine...
  quelque part il voulait rendre service en lisant le message !</p><p class="right"><a href="/sexe/8647334">Voir tous les commentaires →</a></p></div><div class="post article" id="8647188"><p><a href="/travail/8647188" class="fmllink">Aujourd'hui, un ami me propose une soirée, je lui réponds que je ne peux pas car pour moi lundi rime avec partiels.</a><a href="/travail/8647188" class="fmllink"> C'est alors qu'il m'a demandé : &quot;Ah mais vous avez des partiels en école d'infirmières ? Vous apprenez pas juste à faire des piqûres et rassurer les gens ?&quot; VDM</a></p><div class="date"><div class="left_part"><a href="/travail/8647188" id="article_8647188" name="/resume/article/8647188" class="jTip">#8647188</a><br /><span class="dyn-comments">70 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8647188"><a href="javascript:;" onclick="vote('8647188','32221','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">32221</span>)</span> - <span class="dyn-vote-t" id="votebf8647188"><a href="javascript:;" onclick="vote('8647188','2051','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">2051</span>)</span></p><p>Le 29/11/2015 à 03:04 - <a class="liencat" href="/travail">travail</a> - par futurnurse (<a href="/genre/femme" class="light">femme</a>)</p></div></div><div class="more" id="more8647188"><div class="fb-like" data-href="http://www.viedemerde.fr/travail/8647188" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/travail/8647188#new','8647188');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="post article" id="8647147"><p><a href="/travail/8647147" class="fmllink">Aujourd'hui, dans le cadre de ma thèse, j'ai voulu acheter des seringues en pharmacie pour faire des minis bulles de savon.</a><a href="/travail/8647147" class="fmllink"> Je suis reparti avec un kit gratuit pour drogués sans être sûr qu'elle ait cru mon histoire.</a><a href="/travail/8647147" class="fmllink"> VDM</a></p><div class="date"><div class="left_part"><a href="/travail/8647147" id="article_8647147" name="/resume/article/8647147" class="jTip">#8647147</a><br /><span class="dyn-comments">86 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8647147"><a href="javascript:;" onclick="vote('8647147','25715','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">25715</span>)</span> - <span class="dyn-vote-t" id="votebf8647147"><a href="javascript:;" onclick="vote('8647147','4561','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">4561</span>)</span></p><p>Le 28/11/2015 à 23:41 - <a class="liencat" href="/travail">travail</a> - par JunkyOfPhilosophy </p></div></div><div class="more" id="more8647147"><div class="fb-like" data-href="http://www.viedemerde.fr/travail/8647147" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/travail/8647147#new','8647147');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="" id="060d9652eb0ce80b2a9281b2403938d7" data-name="060d9652eb0ce80b2a9281b2403938d7" data-placeholder="http://telegram.viedemerde.fr/exosmic/wysox/ratohydence" style="position: relative;"><script type="text/javascript">var d=document.location;var t=new Date;document.write("<script src='//cdn.dekalee.net/serve/7.js?p="+encodeURIComponent(d.pathname)+"&s="+encodeURIComponent(d.search)+"&t="+t.getTime()+"&ip=88.190.2.209&uid=789983138'>\x3C/script>")</script></div><div class="post article" id="8647135"><p><a href="/inclassable/8647135" class="fmllink">Aujourd'hui, après une soirée arrosée principalement avec des alcools à base de noix de coco, j'ai eu des hauts le cœur quand ma copine est sortie de la salle de bain après une douche Tahiti coco.</a><a href="/inclassable/8647135" class="fmllink"> VDM</a></p><div class="date"><div class="left_part"><a href="/inclassable/8647135" id="article_8647135" name="/resume/article/8647135" class="jTip">#8647135</a><br /><span class="dyn-comments">74 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8647135"><a href="javascript:;" onclick="vote('8647135','27676','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">27676</span>)</span> - <span class="dyn-vote-t" id="votebf8647135"><a href="javascript:;" onclick="vote('8647135','11628','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">11628</span>)</span></p><p>Le 28/11/2015 à 23:01 - <a class="liencat" href="/inclassable">inclassable</a> - par mac06 </p></div></div><div class="more" id="more8647135"><div class="fb-like" data-href="http://www.viedemerde.fr/inclassable/8647135" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/inclassable/8647135#new','8647135');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="post article" id="8647133"><p><a href="/inclassable/8647133" class="fmllink">Aujourd'hui, j'ai décidé de me rendre dans un petit cinéma de quartier pour voir un film d'auteur français, afin de changer un peu de tous ces blockbusters américains purement commerciaux.</a><a href="/inclassable/8647133" class="fmllink"> J'ai compris que c'était une mauvaise idée quand j'ai vu mon voisin installer son oreiller.</a><a href="/inclassable/8647133" class="fmllink"> VDM</a></p><div class="date"><div class="left_part"><a href="/inclassable/8647133" id="article_8647133" name="/resume/article/8647133" class="jTip">#8647133</a><br /><span class="dyn-comments">49 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8647133"><a href="javascript:;" onclick="vote('8647133','32465','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">32465</span>)</span> - <span class="dyn-vote-t" id="votebf8647133"><a href="javascript:;" onclick="vote('8647133','3332','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">3332</span>)</span></p><p>Le 28/11/2015 à 22:48 - <a class="liencat" href="/inclassable">inclassable</a> - par BonneNuit </p></div></div><div class="more" id="more8647133"><div class="fb-like" data-href="http://www.viedemerde.fr/inclassable/8647133" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/inclassable/8647133#new','8647133');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="post article" id="8646882"><p><a href="/inclassable/8646882" class="fmllink">Aujourd'hui, après des années d'essais plus ou moins décevants et divers massacres de mes cheveux dans différents salons, j'ai enfin trouvé MON coiffeur.</a><a href="/inclassable/8646882" class="fmllink"> Je décide donc avec enthousiasme d'y retourner 2 mois plus tard.</a><a href="/inclassable/8646882" class="fmllink"> Le salon a fermé.</a><a href="/inclassable/8646882" class="fmllink"> VDM</a></p><div class="date"><div class="left_part"><a href="/inclassable/8646882" id="article_8646882" name="/resume/article/8646882" class="jTip">#8646882</a><br /><span class="dyn-comments">91 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8646882"><a href="javascript:;" onclick="vote('8646882','41837','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">41837</span>)</span> - <span class="dyn-vote-t" id="votebf8646882"><a href="javascript:;" onclick="vote('8646882','4583','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">4583</span>)</span></p><p>Le 28/11/2015 à 09:56 - <a class="liencat" href="/inclassable">inclassable</a> - par Alloaleau (<a href="/genre/femme" class="light">femme</a>)</p><p style="margin-top:2px;"><a class="liencat" href="/inclassable/8646882#c_8860397">Cette VDM a été commentée par son auteur.</a></p></div></div><div class="more" id="more8646882"><div class="fb-like" data-href="http://www.viedemerde.fr/inclassable/8646882" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/inclassable/8646882#new','8646882');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="post article" id="8646863"><p><a href="/inclassable/8646863" class="fmllink">Aujourd'hui, ayant trouvé des billets d'avion à des prix plus que corrects, je propose à mon copain de passer une semaine à Rome en décembre.</a><a href="/inclassable/8646863" class="fmllink"> Il m'a répondu que ça ne l'intéressait pas, car Star Wars sort durant cette semaine.</a><a href="/inclassable/8646863" class="fmllink"> VDM</a></p><div class="date"><div class="left_part"><a href="/inclassable/8646863" id="article_8646863" name="/resume/article/8646863" class="jTip">#8646863</a><br /><span class="dyn-comments">167 commentaires</span></div><div class="right_part"><p><span class="dyn-vote-j" id="vote8646863"><a href="javascript:;" onclick="vote('8646863','40546','agree');">je valide, c'est une VDM</a> (<span class="dyn-vote-j-data">40546</span>)</span> - <span class="dyn-vote-t" id="votebf8646863"><a href="javascript:;" onclick="vote('8646863','6414','deserve');" class="bf">tu l'as bien mérité</a> (<span class="dyn-vote-t-data">6414</span>)</span></p><p>Le 28/11/2015 à 07:57 - <a class="liencat" href="/inclassable">inclassable</a> - par Erano (<a href="/genre/femme" class="light">femme</a>)</p></div></div><div class="more" id="more8646863"><div class="fb-like" data-href="http://www.viedemerde.fr/inclassable/8646863" data-send="false" data-width="100" data-height="21" data-layout="button_count" data-show-faces="false" data-font="lucida grande"></div><a href="javascript:;" onclick="return twitter_click('http://www.viedemerde.fr/inclassable/8646863#new','8646863');" class="tooltips t_twitter"></a></div>
  </div>
  <div class="pagination"><ul class="left"><li class="active">1</li><li><a href="?page=1">2</a></li><li><a href="?page=2">3</a></li><li><a href="?page=3">4</a></li><li><a href="?page=4">5</a></li><li><a href="?page=5">6</a></li><li><a href="?page=6">7</a></li><li><a href="?page=7">8</a></li><li><a href="?page=8">9</a></li><li><a href="?page=9">10</a></li><li class="inactive"><a href="javascript:;" onclick="pageLauncher(this);">…</a></li><li><a href="?page=1867">1868</a></li></ul><ul class="right"><li class="inactive">&#171; Page précédente</li><li><a href="?page=1" >Page suivante &#187;</a></li></ul></div>﻿
  </div>


  <div class="droite">

  	<div class="part">


      <div class="box" id="illustrated"><h4>La VDM illustrée de C comme Line</h4><a href="/sexe/7195996?utm_source=fmylife&utm_medium=illustrated&utm_campaign=7195996"><span id="illustration" style="background-image: url(http://media.viedemerde.fr/fmylife/data/fr/illust/mini_a6f00af2523507a84cbc44290227cef8.jpg)"></span></a></p><p class="left marged no-margin-top little"><a href="http://www.viedemerde.fr/blog/1745">Présentation de l'artiste</a></p><p class="right marged no-margin-top little"><a href="/illustrations">Toutes les VDM illustrées</a></p></div>
      <div class="box" id="categories">
          <h4>Catégories</h4>
          <ul class="cf">
              <li id="amour" class=""><h3><a href="/amour">Amour</a></h3></li>
  <li id="animaux" class=""><h3><a href="/animaux">Animaux</a></h3></li>
  <li id="argent" class=""><h3><a href="/argent">Argent</a></h3></li>
  <li id="enfants" class=""><h3><a href="/enfants">Enfants</a></h3></li>
  <li id="travail" class=""><h3><a href="/travail">Travail</a></h3></li>
  <li id="sante" class=""><h3><a href="/sante">Santé</a></h3></li>
  <li id="sexe" class=""><h3><a href="/sexe">Sexe</a></h3></li>
  <li id="inclassable" class=""><h3><a href="/inclassable">Inclassable</a></h3></li>
  <li class="tooltips author"><h3><a href="/auteurs">VDM, la suite</a></h3></li><li class="tooltips vdmpeople"><h3><a href="/vdmpeople">La VDM people</a></h3></li>        </ul>
      </div>


  	<div class="box" id="blog">
  		<h4>Blog de l'équipe</h4>
  		<ul>
  			<li><a href="/blog/1745">La VDM illustrée de C comme line</a></li><li class="resume">Bien le bonjour tout le monde.&nbsp;C&#39;est une journ&eacute;e de fiert&eacute; nationale, alors va pas faire trop les andouilles par ici. Y&#39;a un temps pour tout, et m&ecirc;me si l&#39;envie de d&eacute;conner…</li>		</ul>
  		<p class="left marged no-margin-top little">vendredi 27 novembre 2015</p>
  		<p class="right marged no-margin-top little"><a href="/blog">Tout le blog</a></p>
  	</div>

      <div class="likebox" style="height:69px;"><fb:like-box href="http://www.facebook.com/viedemerde" width="300" height="69" show_faces="false" stream="true" header="true"></fb:like-box></div>

      </div>

      <div class="part second">

      <div class="" id="5ea1dab4749bdf3dd9c1a4f0de729c2d" data-name="5ea1dab4749bdf3dd9c1a4f0de729c2d" data-placeholder="http://telegram.viedemerde.fr/exosmic/wysox/dykoucaxible" style="position: relative;"><script type="text/javascript">var d=document.location;var t=new Date;document.write("<script src='//cdn.dekalee.net/serve/20.js?p="+encodeURIComponent(d.pathname)+"&s="+encodeURIComponent(d.search)+"&t="+t.getTime()+"&ip=88.190.2.209&uid=789983138'>\x3C/script>")</script></div>
  	<div class="box autopromo" style="margin-top:10px;">
  		<ul>
          <p style="text-align:center;"><a href="http://www.amazon.fr/VDM-élues-Valette/dp/2350761568/?_encoding=UTF8&camp=1642&creative=6746&linkCode=ur2&tag=viedemerd-21"><img src="http://cdn7.viedemerde.fr/fmylife/data/fr/uploads/couv3d_400.png" style="width:220px;"></a></p>
          <p style="font-size:11px;"><b>VDM : Les Élues</b><br />
          Les élections régionales, très peu pour VDM. Ici seules les anecdotes ont le droit à la sanction démocratique ultime. Adieu la politique, vive la vie merdique !<br />
          Commander : <a href="http://livre.fnac.com/a8748553/Didier-Guedj-VDM-5">Fnac</a>, <a href="http://www.amazon.fr/VDM-élues-Valette/dp/2350761568/?_encoding=UTF8&camp=1642&creative=6746&linkCode=ur2&tag=viedemerd-21">Amazon</a> - <a href="http://www.viedemerde.fr/blog/1743">Plus d'infos</a>

          </p>
  		</ul>
  	</div><div class="box autopromo">
  		<ul>
          <p><a href="http://www.amazon.fr/VDM-Le-jeu-Didier-Guedj/dp/2350761452/?_encoding=UTF8&camp=1642&creative=6746&keywords=vdm%20le%20jeu&linkCode=ur2&qid=1415029480&sr=8-1&tag=viedemerd-21"><img src="http://cdn6.viedemerde.fr/fmylife/images/couv_jeuvdm_mini.jpg"></a></p>
          <p style="font-size:11px;"><b>VDM, le jeu</b><br />
          On y raconte n'importe quoi et c'est ça qui est drôle. À jouer bourré ou non, mais c'est quand même plus drôle pendant l'apéro avec plein d'amis (si tu en as). <br />
          <a href="http://www.amazon.fr/VDM-Le-jeu-Didier-Guedj/dp/2350761452/?_encoding=UTF8&camp=1642&creative=6746&keywords=vdm%20le%20jeu&linkCode=ur2&qid=1415029480&sr=8-1&tag=viedemerd-21">Commander</a> - <a href="http://www.viedemerde.fr/blog/1661">Plus d'infos</a>

          </p>
  		</ul>
  	</div>
      <div class="box"><h4>ZeroPub</h4><p class="left marged"><span id="zeroinfos"></span></p></div>
  	<div class="box footer">
  		<ul><li>&#169; 2008-2015. Créé par <a href="http://www.maximevalette.com">Maxime VALETTE</a>, assisté de <a href="http://www.guillaumepassaglia.com">Guillaume PASSAGLIA</a>, pour <a href="http://www.betacie.com">Beta&amp;Cie</a>.</li>
  			<li><a href="mailto:support@viedemerde.fr">Contactez-nous</a> — <a href="/conditions">Conditions d&#39;utilisation</a>.</li></ul><ul><li>Accéder à la version <a href="/modules/accessibility/switch.php?act=enable">Déficients visuels</a></li></ul>    </div>

  	</div>

  </div>
  </div>

  <div id="footer">


  	<div id="wrapper">
  		<div class="box">

  <p><strong>Le site :</strong> <a href="/boutique">Boutique</a> -

  <a href="/amour">Amour</a> - <a href="/animaux">Animaux</a> - <a href="/argent">Argent</a> - <a href="/enfants">Enfants</a> - <a href="/travail">Travail</a> - <a href="/sante">Santé</a> - <a href="/sexe">Sexe</a> - <a href="/inclassable">Inclassable</a> - 		<a href="/recherche/resultat/?member=1">Membres</a> - <a href="http://forum.viedemerde.fr">Forum</a></p>

  <p><strong>Flux RSS :</strong> <img src="http://cdn7.viedemerde.fr/fmylife/images/bullet_feed.gif" /><a title="Suivre les VDM"  href="http://feedpress.me/viedemerde">Suivre les VDM</a> <img src="http://cdn6.viedemerde.fr/fmylife/images/bullet_feed.gif" /><a title="Suivre le blog VDM"  href="http://feedpress.me/viedemerde/blog">Suivre le blog VDM</a> <img src="http://cdn7.viedemerde.fr/fmylife/images/bullet_feed.gif" /><a title="Suivre les commentaires VDM"  href="http://feedpress.me/viedemerde/comments">Suivre les commentaires VDM</a> <img src="http://cdn6.viedemerde.fr/fmylife/images/bullet_feed.gif" /><a title="Suivre les VDM illustrées"  href="http://feedpress.me/viedemerde/illustrated">Suivre les VDM illustrées</a> </p>			<p><strong>À emporter :</strong> <a href="/applications/officielles#a_141" alt="VDM pour Blackberry">BlackBerry</a> - <a href="/applications/officielles#a_1" alt="VDM sur les mobile android">Android</a> - <a href="/applications/officielles#a_7" alt="VDM pour iPhone et iPod Touch">iPhone/iPod Touch</a> - <a href="/applications/officielles#a_148" alt="VDM pour samsung Wave">Bada</a> - <a href="http://m.viedemerde.fr" alt="Site mobile VDM">Version mobile</a></p>
  			<p><strong>À offrir :</strong> <a href="/boutique#categ3" alt="acheter livre VDM">Livres VDM</a> - <a href="/boutique#categ1" alt="Acheter t-shirts VDM">T-shirts VDM</a> - <a href="/boutique#categ2" alt="Acheter accessoires VDM">Accessoires VDM</a></p>

  <p><strong>Liens :</strong> <a href="http://www.premiere.fr/Cinema" title="Cinéma" target="_blank">Cinéma</a> - <a href="http://programme-tv.premiere.fr/" title="Programmes TV" target="_blank">Programmes TV</a> - <a href="http://series-tv.premiere.fr/" title="Série TV" target="_blank">Séries TV</a> - <a href="http://5euros.com" title="5euros.com" target="_blank">5 euros</a> - <a href="http://www.onveut.com" title="Cadeaux onveut.com" target="_blank" rel="nofollow">Cadeaux onveut.com</a></p><p><strong>Ailleurs :</strong> <a href="http://fmylife.com" alt="[en]">English</a> - <a href="http://vitadimerda.it" alt="[it]">Italiano</a> - <a href="http://vayamierdadevida.com" alt="[es]">Español</a> - <a href="http://tr.fmylife.com" alt="[tr]">Türk</a> - <a href="http://ru.fmylife.com" alt="[ru]">Pусский</a> - <a href="http://se.fmylife.com" alt="[se]">Svenskt</a> - <a href="http://sialbangetgue.com" alt="[id]">Indonesia</a> - <a href="http://pt.fmylife.com" alt="[pt]"></a></p>
  		</div>

  		<div class="box right">

  			<iframe src="https://www.facebook.com/plugins/likebox.php?href=http%3A%2F%2Fwww.facebook.com%2Fviedemerde&amp;width=230&amp;colorscheme=light&amp;show_faces=false&amp;stream=false&amp;header=false&amp;height=62" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:230px; height:62px;" allowTransparency="true"></iframe>

  			<div class="twitter"><a href="http://twitter.com/viedemerde" class="twitter-follow-button" data-lang="fr">Follow @viedemerde</a>
  <script src="http://platform.twitter.com/widgets.js" type="text/javascript"></script></div>

              <p id="counter"><span id="livecounter">3968171</span> VDM envoyées depuis l'ouverture du site. Ça vous en bouche un coin, non ?</p>

  		</div>

  	</div>
  </div>

  <!-- tag Mediametrie -->
  <script LANGUAGE="JavaScript">
  function _eStat_Whap_loaded_func(){
        eStatWhap.serial("EFFETPAP100");
        eStatWhap.send();
  }
  (function() {
  var myscript = document.createElement('script'); myscript.src = "http://w.estat.com/js/whap.js"; myscript.setAttribute('async', 'true');
  var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(myscript, s);
  } )();
  </script>


  <!-- <script type="text/javascript" src="/js/advertisement.js"></script> -->
  </div>
  <script>var user_options=[];user_options['fb.social']=true;</script>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery.form/3.45/jquery.form.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery.lazyload/1.9.0/jquery.lazyload.min.js"></script>
  <script type="text/javascript" src="http://cdn7.viedemerde.fr/fmylife/js/compiled/fr/base.js"></script>
  <script src="http://optim.dekalee.fr/general/dkl.js"></script>
  <!--[if (gte IE 6)&(lte IE 8)]>
    <script type="text/javascript" src="http://cdn7.viedemerde.fr/fmylife/js/selectivizr-min.js"></script>
  <![endif]-->
      <script>
          function principeToggle() {
              var div = $('.post#principe');
              (div.css('display') == 'none') ? div.slideDown() : div.slideUp();
          }

          function sendModeration(id, statut) {
              var boutons = $('.boutons');
              var contain = $('.post.vdm .contain');

              if (boutons.css('opacity') == '0.5') return false;

              boutons.css('opacity',0.5);
              $('div',boutons).css('cursor','default');

              $.get('/ajax/moderate_fr/moderer_livre_2015.php',{vdm:id, statut:statut},function(xml) {
                  $('.post.vdm .contain').slideUp(function() {
                      if ($('billet',xml).length > 0) {
                          contain.prop('id',$('id',xml).text());
                          $('.billet', contain).html($('billet',xml).text());
                          $('.moderate_date', contain).html($('date',xml).text());
                          contain.slideDown();
                      } else {
                          $('.billet', contain).css({'height':40,'padding-top':20,'text-align':'center'})
                              .html('Il n\'y a plus de VDM à modérer. Félicitations !');
                          $('.moderate_date', contain).html('');
                          $('.moderate_abus', contain).html('');
                          contain.slideDown();

                          $('.boutons').fadeOut();
                      }

                      $('span#moderate_status').html($('status',xml).text());
                  });

                  $('.boutons').css('opacity',1);
                  $('.boutons div').css('cursor','pointer');
              });
          }

          $(document).ready(function() {
              $('.boutons #oui').click(function() {
                  var id = $('.post.vdm .contain').prop('id');
                  sendModeration(id, '1');

                  return true;
              });

              $('.boutons #non').click(function() {
                  var id = $('.post.vdm .contain').prop('id');
                  sendModeration(id, '0');

                  return true;
              });
          });
      </script><script type="text/javascript" src="http://telegram.viedemerde.fr/advertrail.js" async></script>
  <script type="text/javascript" src="http://telegram.viedemerde.fr/exosmic/wysox.js" async></script><script>
      (function (a,d,b){var s,r,t;r=0;s=d.createElement('script');
      s.src=a;s.async=1;s.onload=s.onreadystatechange=function(){
      if(!r&&(!this.readyState||this.readyState=='complete')){r=1;b();}};
      t=d.getElementsByTagName('script')[0];t.parentNode.insertBefore(s,t);})
      ("http://malloc.viedemerde.fr/macarena.js", document, function() {new adback.API().initialize();});
  </script>
      <script type="text/javascript">
          window.cookieconsent_options = {"message":"VDM utilise les cookies pour vous assurer une bonne expérience de dégustation.","dismiss":"Ça roule","learnMore":"Plus d'infos","link":"http://www.viedemerde.fr/conditions","theme":"light-bottom"};
      </script>
      <script type="text/javascript" src="//s3.amazonaws.com/cc.silktide.com/cookieconsent.latest.min.js"></script>

  <div id="ads_bottom" style="width: 150px; height: 150px; position: absolute; top: -1500px; left: -1500px;"></div>

  </body>
  </html>"""
}
