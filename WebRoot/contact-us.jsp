<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>尚主题|投诉建议</title>
    <%@include file="/html/common/link_js.jsp"%>  
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
  </head>
  <body>
    <!-- Inserte código aqui -->
    <%@ include file="/html/common/header.jsp"%>
    <!--END HEADER-->

       <section class="container-fluid color-top top-portafolio" style="padding-top: -45px;"><!-- Cabecera pantalla Verde claro -->
        <div class="container" >
            <div class="row texto-blanco top top20">
                <div class="col-sm-6 top top10">
                    <h1>Contact Us</h1>
                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada</p>
                </div>
                <div class="col-sm-6 top top30 size-16">
                    <ul class="pull-right d-f men">
                        <li class="p-l p-r"><a class="unico" href="index.html">Home</a></li>
                        <li>/</li>
                        <li class="p-l p-r texto-plomo">Contact Us</li>
                    </ul>
                </div>
            </div>
        </div>
    </section><!-- Termina el la seccion verde :D -->

    <div class="container-fluid section-fluid top top80">
        <section id="contact-page" class="container" style="padding-top: 70px; padding-bottom: 50px;">
            <div class="row">
                <div class="col-sm-8">
                    <h4 class="texto-griss">Contact Form</h4>
                    <div class="status alert alert-success" style="display: none"></div>
                    <form id="main-contact-form" class="contact-form" name="contact-form" method="post" action="sendemail.php" role="form">
                        <div class="row">
                            <div class="col-sm-5">
                                <div class="form-group">
                                    <input type="text" class="form-control" required="required" placeholder="First Name">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" required="required" placeholder="Last Name">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" required="required" placeholder="Email address">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-lg">Send Message</button>
                                </div>
                            </div>
                            <div class="col-sm-7">
                                <textarea name="message" id="message" required="required" class="form-control" rows="8" placeholder="Message"></textarea>
                            </div>
                        </div>
                    </form>
                </div><!--/.col-sm-8-->
                <div class="col-sm-4">
                    <h4 class="texto-griss">Our Location</h4>
                    <iframe width="100%" height="215" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com.au/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Dhaka,+Dhaka+Division,+Bangladesh&amp;aq=0&amp;oq=dhaka+ban&amp;sll=40.714353,-74.005973&amp;sspn=0.836898,1.815491&amp;ie=UTF8&amp;hq=&amp;hnear=Dhaka+Division,+Bangladesh&amp;t=m&amp;ll=24.542126,90.293884&amp;spn=0.124922,0.411301&amp;z=8&amp;output=embed"></iframe>
                </div><!--/.col-sm-4-->
            </div>
        </section><!--/#contact-page-->
    </div>






    <footer class="container-fluid footer-fluid top top80">
        <div class="container p-t p-b">
            <div class="row top top10">
                <div class="col-md-3">
                  <h4 class="texto-blanco">About us</h4>
                  <p class="texto-plomo">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante.</p>
                  <p class="texto-plomo">Pellentesque habitant morbi tristique senectus.</p>
                </div>
                <!-- Primer Recuadro Finalizado -->
                <div class="col-md-2">
                  <h4 class="texto-blanco">Company</h4>
                  <ul class="pl-0 men texto-plomo">
                    <li><span class="glyphicon glyphicon-chevron-right"></span><a href="#">The Company</a></li>
                    <li><span class="glyphicon glyphicon-chevron-right"></span><a href="#">Our Team</a></li>
                    <li><span class="glyphicon glyphicon-chevron-right"></span><a href="#">Our Partners</a></li>
                    <li><span class="glyphicon glyphicon-chevron-right"></span><a href="#">Our Services</a></li>
                    <li><span class="glyphicon glyphicon-chevron-right"></span><a href="#">Faq</a></li>
                    <li><span class="glyphicon glyphicon-chevron-right"></span><a href="#">Contact Us</a></li>
                    <li><span class="glyphicon glyphicon-chevron-right"></span><a href="#">Privacy Policy</a></li>
                    <li><span class="glyphicon glyphicon-chevron-right"></span><a href="#">Terms of Use</a></li>
                    <li><span class="glyphicon glyphicon-chevron-right"></span><a href="#">Copyright</a></li>
                  </ul>
                </div>
                <!-- Primer Recuadro Finalizado -->
                <div class="col-md-4">
                    <h4 class="texto-blanco">Latest Blog</h4>
                    <div class="enlace d-f p-b">
                        <img class="pie-img" src="images/blog/thumb1.jpg" alt="">
                        <div class="p-l texto-plomo">
                            <ul class="pl-0 men texto-plomo">
                                <li><a href="#">Pellentesque habitant morbi tristique senectus</a></li>
                            </ul>
                            <p class="size-10">Posted 17 Aug 2013</p>
                        </div>
                    </div>
                    <div class="enlace d-f p-b">
                        <img class="pie-img" src="images/blog/thumb1.jpg" alt="">
                        <div class="p-l texto-plomo">
                            <ul class="pl-0 men texto-plomo">
                                <li><a href="#">Pellentesque habitant morbi tristique senectus</a></li>
                            </ul>
                            <p class="size-10">Posted 17 Aug 2013</p>
                        </div>
                    </div>
                    <div class="enlace d-f p-b">
                        <img class="pie-img" src="images/blog/thumb1.jpg" alt="">
                        <div class="p-l texto-plomo">
                            <ul class="pl-0 men texto-plomo">
                                <li><a href="#">Pellentesque habitant morbi tristique senectus</a></li>
                            </ul>
                            <p class="size-10">Posted 17 Aug 2013</p>
                        </div>
                    </div>
                </div>
                <!-- Primer Recuadro Finalizado -->
                <div class="col-md-3 menu3">
                  <h4 class="texto-blanco">Adress</h4>
                    <div class="texto-plomo">
                        <h5 class="negrita">Twitter, Inc.</h5>
                        <p class="mb-0">795 Folsom Ave, Suite 600</p>
                        <p class="mb-0">San Francisco, CA 94107</p>
                        <p class="mb-0"><abbr title="Phone">P:</abbr> (123) 456-7890</p>
                    </div>
                  <h4 class="texto-blanco">Newsletter</h4>
                  <form role="form">
                        <div class="input-group" style="width: 210px;">
                            <input type="text" class="form-control" autocomplete="off" placeholder="Enter your email">
                            <span class="input-group-btn">
                                <button class="btn btn-danger" type="button">Go!</button>
                            </span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </footer>
    <footer class="container-fluid footer-fluid2 top top80" style="padding-bottom: 20px;">
        <div class="container pb-0 mb-0 top top10">
            <div class="row d-f alinear">
                <div class="col-sm-6 p-t">
                    <p class="texto-plomo none">© 2013
                        <a class="texto-plomo rojo" href="#">ShapeBootstrap</a>. All Rights Reserved. All Rights Reserved.
                    </p>
                </div>
                <div class="col-sm-6 p-t">
                    <ul class="pull-right d-f men texto-plomo quita-espacio">
                        <li class="p-r"><a href="#">Home</a></li>
                        <li class="p-l p-r"><a href="#">About Us</a></li>
                        <li class="p-l p-r"><a href="#">Faq</a></li>
                        <li class="p-l p-r"><a href="#">Contact Us</a></li>
                        <li class="p-l p-r"><a id="gototop" class="gototop" href="#"><i class="icon-chevron-up"></i></a></li><!--#gototop-->
                    </ul>
                </div>
            </div>
        </div>
    </footer><!--/#footer-->


    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>