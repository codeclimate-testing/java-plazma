/*!
 * Ext JS Library 3.2.1
 * Copyright(c) 2006-2010 Ext JS, Inc.
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.onReady(function(){

    Ext.QuickTips.init();


    //var store = new Ext.data.ArrayStore({
    //    fields: ['abbr', 'state'],
    //    data : Ext.exampledata.states // from states.js
    //});

   
    var menu = new Ext.menu.Menu({
        id: 'mainMenu',
        style: {
            overflow: 'visible'     // For the Combo popup
        },
        items: [
                              // A Field in a Menu
            {
                text: 'Menu Item 1.1',
		handler: onItemClick
            }, '-', {
                text: 'Menu Item 1.2',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                        //'<b class="menu-title">Choose a Theme</b>',
                        {
                            text: 'Menu Item 1.2.1',
			    handler: onItemClick
                        }, {
                            text: 'MenuItem 1.2.2',
			    handler: onItemClick
                        }, {
                            text: 'Menu Item 1.2.3',
			    handler: onItemClick
                        }, {
                            text: 'Menu Item 1.2.4',
			    handler: onItemClick
                        }
                    ]
                }
            }
        ]
    });

    var tb = new Ext.Toolbar();
    tb.render('toolbar');

    tb.add({
            text:'Menu1',
            iconCls: 'bmenu',  // <-- icon
            menu: menu  // assign menu by instance
        });

    menu.addSeparator();

    // Menus have a rich api for
    // adding and removing elements dynamically
    var item = menu.add({
        text: 'Dynamically added Item'
    });
    // items support full Observable API
    item.on('click', onItemClick);

    // items can easily be looked up
    menu.add({
        text: 'Disabled Item',
        id: 'disableMe'  // <-- Items can also have an id for easy lookup
        // disabled: true   <-- allowed but for sake of example we use long way below
    });
    // access items by id or index
    menu.items.get('disableMe').disable();

    // They can also be referenced by id in or components
    tb.add('-', {
        icon: 'list-items.gif', // icons can also be specified inline
        cls: 'x-btn-icon',
        tooltip: '<b>Quick Tips</b><br/>Icon only button with tooltip'
    }, '-');

    //var scrollMenu = new Ext.menu.Menu();
    //for (var i = 0; i < 50; ++i){
    //    scrollMenu.add({
    //        text: 'Item ' + (i + 1)
    //    });
    //}

    // scrollable menu
    //tb.add({
    //    icon: 'preview.png',
    //    cls: 'x-btn-text-icon',
    //   text: 'Scrolling Menu',
    //    menu: scrollMenu
    //});


    tb.doLayout();

    // functions to display feedback
    function onButtonClick(btn){
        Ext.example.msg('Button Click','You clicked the "{0}" button.', btn.text);
    }

    function onItemClick(item){
        Ext.example.msg('Menu Click', 'You clicked the "{0}" menu item.', item.text);
    }

    function onItemCheck(item, checked){
        Ext.example.msg('Item Check', 'You {1} the "{0}" menu item.', item.text, checked ? 'checked' : 'unchecked');
    }

    function onItemToggle(item, pressed){
        Ext.example.msg('Button Toggled', 'Button "{0}" was toggled to {1}.', item.text, pressed);
    }

});
