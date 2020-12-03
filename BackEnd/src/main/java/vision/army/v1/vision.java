package vision.army.v1;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vision.army.v1.ApiResource.*;
import vision.army.entity.*;
import vision.army.exception.*;
import vision.army.service.*;
import io.swagger.annotations.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vision")
@Api(description = "manage and execute  ")
public class vision {
    private userService userService;
    private  brandService  brandService;
    private  cartService cartService;
    private clientLocationService clientLocationService;
    private  clientService clientService;
    private favouriteService favouriteService;
    private offerService offerService;
    private  ordersService ordersService;
    private prodTypeService prodTypeService;
    private  productImageService productImageService;
    private productService productService;
    private resaleService resaleService;

    public vision(userService userService, brandService brandService,cartService cartService,
                  clientLocationService clientLocationService,clientService clientService,
                  favouriteService favouriteService, offerService offerService, ordersService ordersService,
                  prodTypeService prodTypeService, productImageService productImageService,
                  productService productService, resaleService resaleService) {
        this.userService = userService;
        this.brandService = brandService;
        this.cartService = cartService;
        this.clientLocationService = clientLocationService;
        this.clientService = clientService;
        this.favouriteService = favouriteService;
        this.offerService = offerService;
        this.ordersService = ordersService;
        this.prodTypeService = prodTypeService;
        this.productImageService = productImageService;
        this.productService = productService;
        this.resaleService = resaleService;
    }

    ////////////////////////////             USER             \\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Transactional
    @ApiOperation("get all users ")
    @GetMapping(value = "/user",produces = MediaType.APPLICATION_JSON_VALUE)
    public usersResources getAllUsers(){
        return new usersResources(this.userService.getAllUsers());

    }
    @Transactional
    @ApiOperation("get detail of  user according to given id ")
    @GetMapping(value = "/user/{userID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public userResource getUserDetails(@PathVariable("userID") int userID ){

        return new userResource(this.userService.getAnUser(userID));

    }
    @Transactional
    @ApiOperation("update detail of  user according to given id ")
    @PutMapping(value = "/user/{userID}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUserDetails(@PathVariable("userID") int userID  , @Valid @RequestBody user user){

        this.userService.updateAnUser(userID , user);

        URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand()
                    .toUri();

        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }


    @Transactional
    @ApiOperation("delete user according to given id ")
    @DeleteMapping(value = "/user/{userID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@PathVariable("userID") int userID){

        this.userService.deleteAnUser(userID);

        return ResponseEntity.noContent().build();

    }
    ///////////////////////////////           PRODUCT              \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Transactional
    @ApiOperation(value = "create new product")
    @PostMapping(value = "/product"    , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewProduct(@Valid @RequestBody product product ){
        this.productService.createAnProduct(product);

            URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/product")
                .path("/" + product.getProductID())
                .buildAndExpand().toUri();

        return  ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("get all products ")
    @GetMapping(value = "/product",produces = MediaType.APPLICATION_JSON_VALUE)
    public productsResources getAllProducts(){
        return new productsResources(this.productService.getAllProducts());

    }

    @Transactional
    @ApiOperation("get all most sales products ")
    @GetMapping(value = "/product/mostSales",produces = MediaType.APPLICATION_JSON_VALUE)
    public productsResources getAllMostSalesProducts(){
        return new productsResources(this.productService.getAllMostSalesProduct());

    }

    @Transactional
    @ApiOperation("get all most rated products ")
    @GetMapping(value = "/product/mostRated",produces = MediaType.APPLICATION_JSON_VALUE)
    public productsResources getAllMostRatedProducts(){
        return new productsResources(this.productService.getAllMostRatedProduct());

    }

    @Transactional
    @ApiOperation("get all products by brandID ")
    @GetMapping(value = "/product/brand/{brandID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public productsResources getAllProductsByBrandID(@PathVariable("brandID") int brandID){
        return new productsResources(this.productService.getAllProductsByBrand(brandID));

    }

    @Transactional
    @ApiOperation("get all products by product type ID ")
    @GetMapping(value = "/product/prodType/{prodTypeID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public productsResources getAllProductsByProdTypeID(@PathVariable("prodTypeID") int prodTypeID){
        return new productsResources(this.productService.getAllProductsByProductType(prodTypeID));

    }

    @Transactional
    @ApiOperation("get all products by product type main ID ")
    @GetMapping(value = "/product/prodTypeMain/{prodTypeID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public productsResources getAllProductsByProdTypeMainID(@PathVariable("prodTypeID") int prodTypeID){
        return new productsResources(this.productService.getAllProductsByProductTypeMain(prodTypeID));

    }

    @Transactional
    @ApiOperation("get all products by name ")
    @GetMapping(value = "/product/prodName/{prodName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public productsResources getAllProductsByProdTypeMainID(@PathVariable("prodName") String prodName){
        return new productsResources(this.productService.getAllProductsByName(prodName));

    }

    @Transactional
    @ApiOperation("get all products by price ")
    @GetMapping(value = "/product/price/{price1}/{price2}",produces = MediaType.APPLICATION_JSON_VALUE)
    public productsResources getAllProductsByPrice(@PathVariable("price1") int price1 ,@PathVariable("price2") int price2){
        return new productsResources(this.productService.getAllProductsByPriceRang(price1,price2));

    }

    @Transactional
    @ApiOperation("get a product details according to given ID")
    @GetMapping(value = "/product/{prodID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public productResource getProductDetails(@PathVariable("prodID") int prodID){

        return new productResource(this.productService.getProductByID(prodID));
    }

    @Transactional
    @ApiOperation("delete product according to given id ")
    @DeleteMapping(value = "/product/{productID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@PathVariable("productID") int productID){

        this.productService.deleteProduct(productID);

        return ResponseEntity.noContent().build();

    }

    @Transactional
    @ApiOperation("delete all products ")
    @DeleteMapping(value = "/product",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteAllProduct(){

        this.productService.deleteAllProduct();

        return ResponseEntity.noContent().build();

    }

    @Transactional
    @ApiOperation("update detail of  product according to given id ")
    @PutMapping(value = "/product/{productID}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProductDetails(@PathVariable("productID") int productID  , @Valid @RequestBody product product){

        this.productService.updateAnProduct(product ,productID);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand()
                .toUri();

        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }
        ///////// productImages \\\\\\\\\
    @Transactional
    @ApiOperation("get all images of a product ")
    @GetMapping(value = "/product/{prodID}/prodImages",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<productImage> getAllImagesForProduct(@PathVariable("prodID") int prodID){
        return this.productImageService.getProductImageForProduct(prodID);

    }

    @Transactional
    @ApiOperation("get  image of a product according to given imageID ")
    @GetMapping(value = "/product/prodImages/{prodImageID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public productImage getProdImageByID(@PathVariable("prodImageID") int prodImageID){
        return this.productImageService.getProductImageByID(prodImageID);

    }

    @Transactional
    @ApiOperation(value = "add new images for a product")
    @PostMapping(value = "/product/{prodID}/prodImages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewProductImage(@PathVariable("prodID") int prodID ,@Valid @RequestBody productImage productImage ){
        this.productImageService.createAnProductImageForProduct(prodID,productImage);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/product/prodImages")
                .path("/"+productImage.getPrdImID())
                .buildAndExpand().toUri();

        return  ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("delete image of a product according to given imageID ")
    @DeleteMapping(value = "/product/prodImages/{prodImageID}")
    public ResponseEntity deleteProdImageByID(@PathVariable("prodImageID") int prodImageID){
         this.productImageService.deleteProductImage(prodImageID);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @ApiOperation("check if product is in order process")
    @GetMapping(value = "/product/{prodID}/checkOrder",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean checkIfProductIsInOrderProcess(@PathVariable("prodID") int prodID){

        return this.ordersService.checkIfProductInorders(prodID);
    }
///////////////////////////////////////          CLIENT                \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Transactional
    @ApiOperation("create a new client")
    @PostMapping(value = "/client",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAnewClient(@Valid @RequestBody client client) {
        this.clientService.createAnClient(client);
        URI location =ServletUriComponentsBuilder
                        .fromCurrentRequestUri()
                        .replacePath("/vision/client")
                        .path("/"+client.getClientID())
                        .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("update client details according to given id")
    @PutMapping(value = "/client/{clientID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateClient(@PathVariable("clientID") int clientID,  @Valid @RequestBody client client) {
        this.clientService.updateClient(clientID, client);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("delete client details according to given id")
    @DeleteMapping(value = "/client/{clientID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteClient(@PathVariable("clientID") int clientID) {
        this.clientService.deleteClient(clientID);
        return ResponseEntity.noContent().build();

    }

    @Transactional
    @ApiOperation("delete all clients")
    @DeleteMapping(value = "/client",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteAllClient() {
        this.clientService.deleteAllClients();
        return ResponseEntity.noContent().build();

    }


    @Transactional
    @ApiOperation("get all clients ")
    @GetMapping(value = "/client",produces = MediaType.APPLICATION_JSON_VALUE)
    public clientResources getAllClients(){
        return new clientResources(this.clientService.getALLClient());

    }

    @Transactional
    @ApiOperation("get client by ID")
    @GetMapping(value = "/client/{clientID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public clientResource getClientByID(@PathVariable("clientID") int clientID){
        return new clientResource(this.clientService.getClientByID(clientID));

    }

    @Transactional
    @ApiOperation("get client by name")
    @GetMapping(value = "/client/name/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public clientResources getClientByName(@PathVariable("name") String name){
        return new clientResources(this.clientService.getClientByName(name));

    }

    @Transactional
    @ApiOperation("get client by email")
    @GetMapping(value = "/client/email/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
    public clientResource getClientByEmail(@PathVariable("email") String email){
        return new clientResource(this.clientService.getClientByEmail(email));

    }

    @Transactional
    @ApiOperation("get client by phone")
    @GetMapping(value = "/client/phone/{phone}",produces = MediaType.APPLICATION_JSON_VALUE)
    public clientResource getClientByPhone(@PathVariable("phone") String phone){
        return new clientResource(this.clientService.getClientByPhone(phone));

    }

    @Transactional
    @ApiOperation("get clients by gender")
    @GetMapping(value = "/client/gender/{gender}",produces = MediaType.APPLICATION_JSON_VALUE)
    public clientResources getClientByGender(@PathVariable("gender") String gender){
        return new clientResources(this.clientService.getClientsByGender(gender));

    }
            ////////////// client location \\\\\\\\\\\\
    @Transactional
    @ApiOperation("create a new client location according to client ID")
    @PostMapping(value = "/client/{clientID}/location",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAnewClientLocation(@PathVariable("clientID") int clientID,@Valid @RequestBody clientLocation clientLocation) {
        this.clientLocationService.createAnClientLocationForClient(clientID,clientLocation);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client/location")
                .path("/"+clientLocation.getClLocationID())
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("get client location according to given id")
    @GetMapping(value = "/client/{clientID}/location",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<clientLocation> getLocationForClient(@PathVariable("clientID") int clientID){
        return this.clientLocationService.getClientLocationForClient(clientID);

    }

    @Transactional
    @ApiOperation("delete client location according to given id")
    @DeleteMapping(value = "/client/location/{locationID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteLocation(@PathVariable("locationID") int locationID){
        this.clientLocationService.deleteClientLocation(locationID);
        return ResponseEntity.noContent().build();

    }

    @Transactional
    @ApiOperation("update client location according to  locationID")
    @PutMapping(value = "/client/location/{locationID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateClientLocation( @PathVariable("locationID") int locationID
                                                    ,@Valid @RequestBody clientLocation clientLocation) {
        this.clientLocationService.updateClientLocation(locationID,clientLocation);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client/location")
                .path("/"+clientLocation.getClLocationID())
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("get client location according to given id")
    @GetMapping(value = "/client/location/{locationID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public clientLocation getLocationByID(@PathVariable("locationID") int locationID){
        return this.clientLocationService.getClientLocationByID(locationID);


    }

    ////////////// cart \\\\\\\\\\\\
    @Transactional
    @ApiOperation("create a new cart according to client ID")
    @PostMapping(value = "/client/{clientID}/cart",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAnewCart(@PathVariable("clientID") int clientID,@Valid @RequestBody cart cart) {
        this.cartService.createAnCartForClient(clientID,cart);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client/cart")
                .path("/"+cart.getCartID())
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("get cart for client according to given id")
    @GetMapping(value = "/client/{clientID}/cart",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<cart> getCartForClient(@PathVariable("clientID") int clientID){
        return this.cartService.getCartForClient(clientID);

    }

    @Transactional
    @ApiOperation("delete cart for client according to given id")
    @DeleteMapping(value = "/client/cart/{cartID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCart(@PathVariable("cartID") int cartID){
        this.cartService.deleteCart(cartID);
        return ResponseEntity.noContent().build();

    }

    @Transactional
    @ApiOperation("update cart for client according to  locationID")
    @PutMapping(value = "/client/cart/{cartID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCart( @PathVariable("cartID") int cartID
            ,@Valid @RequestBody cart cart) {
        this.cartService.updateCart(cartID,cart);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client/cart")
                .path("/"+cart.getCartID())
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }
    @Transactional
    @ApiOperation("update cart confirmation for client according to  locationID")
    @PutMapping(value = "/client/cart/{cartID}/{confirm}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCartConfirmation( @PathVariable("cartID") int cartID,
                                                  @PathVariable("confirm") boolean confirm ) {
        this.cartService.updateCartForConfirm(cartID,confirm);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client/cart")
                .path("/"+cartID)
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("get cart fot client according to given id")
    @GetMapping(value = "/client/cart/{cartID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public cart getCartByID(@PathVariable("cartID") int cartID){
        return this.cartService.getCartByID(cartID);
    }

    ////////////// resale  \\\\\\\\\\\\


    @Transactional
    @ApiOperation("create a new resale according to client ID")
    @PostMapping(value = "/client/{clientID}/resale",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAnewResale(@PathVariable("clientID") int clientID,@Valid @RequestBody resale resale) {
        this.resaleService.createAnResaleForClient(clientID,resale);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client/resale")
                .path("/"+resale.getReSaleID())
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("get resale for client according to given id")
    @GetMapping(value = "/client/{clientID}/resale",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<resale> getResaleForClient(@PathVariable("clientID") int clientID){
        return this.resaleService.getResaleForClient(clientID);

    }

    @Transactional
    @ApiOperation("delete resale for client according to given id")
    @DeleteMapping(value = "/client/resale/{resaleID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteResale(@PathVariable("resaleID") int resaleID){
        this.resaleService.deleteResale(resaleID);
        return ResponseEntity.noContent().build();

    }

    @Transactional
    @ApiOperation("update resale for client according to  locationID")
    @PutMapping(value = "/client/resale/{resaleID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateResale( @PathVariable("resaleID") int resaleID
            ,@Valid @RequestBody resale resale) {
        this.resaleService.updateResale(resaleID,resale);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client/resale")
                .path("/"+resaleID)
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }
    @Transactional
    @ApiOperation("update resale confirmation for client according to  locationID")
    @PutMapping(value = "/client/resale/{resaleID}/{confirm}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateResaleConfirmation( @PathVariable("resaleID") int resaleID,
                                                  @PathVariable("confirm") boolean confirm ) {
        this.resaleService.updateResaleForConfirm(resaleID,confirm,new Date());
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client/resale")
                .path("/"+resaleID)
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("get resale  according to given id")
    @GetMapping(value = "/client/resale/{resaleID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public resale getResaleByID(@PathVariable("resaleID") int resaleID){
        return this.resaleService.getResaleByID(resaleID);
    }

    @Transactional
    @ApiOperation("get resale  according to resaleDate")
    @GetMapping(value = "/client/resaleDate/{resaleDate}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<resale> getResaleByResaleDate(@PathVariable("resaleDate") Date resaleDate){
        return this.resaleService.getResaleByDate(resaleDate);
    }

    @Transactional
    @ApiOperation("get resale  according to confirmDate")
    @GetMapping(value = "/client/resaleConfirmDate/{confirmDate}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<resale> getResaleByConfirmDate(@PathVariable("confirmDate") Date confirmDate){
        return this.resaleService.getResaleByConfirmDate(confirmDate);
    }

    @Transactional
    @ApiOperation("get resale  according to confirm")
    @GetMapping(value = "/client/resaleConfirm/{confirm}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<resale> getResaleByConfirm(@PathVariable("confirm") boolean confirm){
        return this.resaleService.getResaleByConfirm(confirm);
    }
    ////////////// favourite  \\\\\\\\\\\\\\
    @Transactional
    @ApiOperation("create a new favourite according to client ID")
    @PostMapping(value = "/client/{clientID}/favourite",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAnewFavourite(@PathVariable("clientID") int clientID,@Valid @RequestBody favourite favourite) {
        this.favouriteService.createAnFavouriteForClient(clientID,favourite);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client/favourite")
                .path("/"+favourite.getFavID())
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("get favourite for client according to given id")
    @GetMapping(value = "/client/{clientID}/favourite",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<favourite> getFavouriteForClient(@PathVariable("clientID") int clientID){
        return this.favouriteService.getFavouriteForClient(clientID);

    }

    @Transactional
    @ApiOperation("delete favourite for client according to given id")
    @DeleteMapping(value = "/client/favourite/{favouriteID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteFavourite(@PathVariable("favouriteID") int favouriteID){
        this.favouriteService.deleteFavourite(favouriteID);
        return ResponseEntity.noContent().build();

    }

    @Transactional
    @ApiOperation("update favourite for client according to  locationID")
    @PutMapping(value = "/client/favourite/{favouriteID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateFavourite( @PathVariable("favouriteID") int favouriteID
            ,@Valid @RequestBody favourite favourite) {
        this.favouriteService.updateFavourite(favouriteID,favourite);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client/favourite")
                .path("/"+favourite.getFavID())
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("get favourite for client according to given id")
    @GetMapping(value = "/client/favourite/{favouriteID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public favourite getFavouriteByID(@PathVariable("favouriteID") int favouriteID){
        return this.favouriteService.getFalngvouriteByID(favouriteID);
    }
    ////////////// order  \\\\\\\\\\\\\\
    @Transactional
    @ApiOperation("create a new orders according to client ID")
    @PostMapping(value = "/client/{clientID}/orders",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAnewOrder(@PathVariable("clientID") int clientID,@Valid @RequestBody orders orders) {
        this.ordersService.createAnOrdersForClient(clientID,orders);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client/orders")
                .path("/"+orders.getOrdersID())
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("get orders for client according to given id")
    @GetMapping(value = "/client/{clientID}/orders",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<orders> getOrdersForClient(@PathVariable("clientID") int clientID){
        return this.ordersService.getOrdersForClient(clientID);

    }

    @Transactional
    @ApiOperation("delete orders for client according to given id")
    @DeleteMapping(value = "/client/orders/{ordersID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteOrders(@PathVariable("ordersID") int ordersID){
        this.ordersService.deleteOrders(ordersID);
        return ResponseEntity.noContent().build();

    }

    @Transactional
    @ApiOperation("update orders for client according to  ordersID")
    @PutMapping(value = "/client/orders/{ordersID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateOrders( @PathVariable("ordersID") int ordersID
            ,@Valid @RequestBody orders orders) {
        this.ordersService.updateOrders(ordersID,orders);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/client/orders")
                .path("/"+ordersID)
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("get orders for client according to given id")
    @GetMapping(value = "/client/orders/{ordersID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public orders getOrdersByID(@PathVariable("ordersID") int ordersID){
        return this.ordersService.getOrdersByID(ordersID);
    }

    @Transactional
    @ApiOperation("get orders for client according to deliverState")
    @GetMapping(value = "/client/{clientID}/deliverState/{deliverState}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<orders> getOrdersByDeliverState(@PathVariable("clientID") int clientID,@PathVariable("deliverState") String deliverState){
        return this.ordersService.getOrdersByStateForClient(clientID,deliverState);
    }


    //////////////////////////////////////////      ORDERS       \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Transactional
    @ApiOperation("get all orders")
    @GetMapping(value = "/orders",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<orders> getAllOrders(){
        return this.ordersService.getAllOrders();

    }

    @Transactional
    @ApiOperation("get all orders by deliverState")
    @GetMapping(value = "/orders/state/{deliverState}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<orders> getAllOrdersByState(@PathVariable("deliverState") String deliverState){
        return this.ordersService.getOrdersByState(deliverState);

    }

    @Transactional
    @ApiOperation("get all orders by date")
    @GetMapping(value = "/orders/date/{date}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<orders> getAllOrdersByDate(@PathVariable("date") Date date){
        return this.ordersService.getOrdersByOrderDate(date);

    }

    @Transactional
    @ApiOperation("get all orders by deliverDate")
    @GetMapping(value = "/orders/deliverDate/{deliverDate}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<orders> getAllOrdersByDeliverDate(@PathVariable("deliverDate") Date deliverDate){
        return this.ordersService.getOrdersByDeliveredDate(deliverDate);

    }

    @Transactional
    @ApiOperation("get all orders by price ")
    @GetMapping(value = "/orders/price/{price1}/{price2}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<orders> getAllOrdersByDeliverDate(@PathVariable("price1") int  price1 ,@PathVariable("price2") int  price2){
        return this.ordersService.getOrdersByPriceRang(price1,price2);

    }

    //////////////////////////////////////////     BRAND      \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Transactional
    @ApiOperation("create a new brand")
    @PostMapping(value = "/brand",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAnewBrand(@Valid @RequestBody brand brand) {
        this.brandService.createBrand(brand);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/brand")
                .path("/"+brand.getBrandID())
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("update brand details according to given id")
    @PutMapping(value = "/brand/{brandID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateBrand(@PathVariable("brandID") int brandID,  @Valid @RequestBody brand brand) {
        this.brandService.createBrand(brand);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("delete brand details according to given id")
    @DeleteMapping(value = "/brand/{brandID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteBrand(@PathVariable("brandID") int brandID) {
        this.brandService.deleteBrand(brandID);
        return ResponseEntity.noContent().build();

    }

    @Transactional
    @ApiOperation("get all brand ")
    @GetMapping(value = "/brand",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<brand> getAllBrands(){
        return this.brandService.getAllBrands();

    }

    @Transactional
    @ApiOperation("get brand by ID")
    @GetMapping(value = "/brand/{brandID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public brand getBrandByID(@PathVariable("brandID") int brandID){
        return this.brandService.getBrandByID(brandID);

    }
    //////////////////////////////////////////     OFFER      \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Transactional
    @ApiOperation("create a new offer")
    @PostMapping(value = "/offer",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAnewOffer(@Valid @RequestBody offer offer) {
        this.offerService.createOffer(offer);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/offer")
                .path("/"+offer.getOfferID())
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("update offer details according to given id")
    @PutMapping(value = "/offer/{offerID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateOffer(@PathVariable("offerID") int offerID,  @Valid @RequestBody offer offer) {
        this.offerService.updateOffer(offerID,offer);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("delete offer details according to given id")
    @DeleteMapping(value = "/offer/{offerID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteOffer(@PathVariable("offerID") int offerID) {
        this.offerService.deleteOffer(offerID);
        return ResponseEntity.noContent().build();

    }

    @Transactional
    @ApiOperation("get all offer ")
    @GetMapping(value = "/offer",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<offer> getAlloffers(){
        return this.offerService.getAllOffers();

    }

    @Transactional
    @ApiOperation("get offer by ID")
    @GetMapping(value = "/offer/{offerID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public offer getOfferByID(@PathVariable("offerID") int offerID){
        return this.offerService.getOfferByID(offerID);

    }

    //////////////////////////////////////////     product type      \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Transactional
    @ApiOperation("create a new productType")
    @PostMapping(value = "/productType",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAnewProdType(@Valid @RequestBody productType productType) {
        this.prodTypeService.createAnProdType(productType);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/vision/productType")
                .path("/"+productType.getPrdTypeID())
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("update productType details according to given id")
    @PutMapping(value = "/productType/{productTypeID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProdType(@PathVariable("productTypeID") int productTypeID,  @Valid @RequestBody productType productType) {
        this.prodTypeService.createAnProdType(productType);
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .buildAndExpand().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();

    }

    @Transactional
    @ApiOperation("delete productType details according to given id")
    @DeleteMapping(value = "/productType/{productTypeID}",produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProdType(@PathVariable("productTypeID") int productTypeID) {
        this.prodTypeService.deleteProductType(productTypeID);
        return ResponseEntity.noContent().build();

    }

    @Transactional
    @ApiOperation("get all productType ")
    @GetMapping(value = "/productType",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<productType> getAllProdType(){
        return this.prodTypeService.getAllProductTypes();

    }

    @Transactional
    @ApiOperation("get productType by ID")
    @GetMapping(value = "/productType/{productTypeID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public productType getProdTypeByID(@PathVariable("productTypeID") int productTypeID){
        return this.prodTypeService.getProductTypeByID(productTypeID);

    }
}
