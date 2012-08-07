/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.client.editors.test;

import javax.inject.Inject;

import org.uberfire.client.annotations.WorkbenchMenu;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.client.workbench.WorkbenchMenuBar;
import org.uberfire.client.workbench.WorkbenchMenuItem;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.MenuItem;

/**
 * A stand-alone Presenter annotated to hook into the Workbench
 */
@WorkbenchScreen(identifier = "Test")
public class TestPresenter {

    public interface View
        extends
        IsWidget {
    }

    @Inject
    public View view;

    public TestPresenter() {
    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "Test";
    }

    @WorkbenchPartView
    public IsWidget getView() {
        return view;
    }

    @WorkbenchMenu
    public WorkbenchMenuBar getMenuBar() {
        final WorkbenchMenuBar menuBar = new WorkbenchMenuBar();

        //Sub-menu#1 - All items enabled
        final WorkbenchMenuBar subMenuBar1 = new WorkbenchMenuBar( true );
        menuBar.addItem( new MenuItem( "TestPresenter menu-1",
                                       subMenuBar1 ) );
        for ( int i = 0; i < 3; i++ ) {
            final String caption = "TestPresenter menu-1:Item:" + i;
            final WorkbenchMenuItem item = new WorkbenchMenuItem( caption,
                                                                  new Command() {

                                                                      @Override
                                                                      public void execute() {
                                                                          Window.alert( "You clicked " + caption );
                                                                      }

                                                                  } );
            item.setHasPermission( true );
            subMenuBar1.addItem( item );
        }

        //Sub-menu#2 - The first three items enabled
        final WorkbenchMenuBar subMenuBar2 = new WorkbenchMenuBar( true );
        menuBar.addItem( new MenuItem( "TestPresenter menu-2",
                                       subMenuBar2 ) );
        for ( int i = 0; i < 5; i++ ) {
            final String caption = "TestPresenter menu-2:Item:" + i;
            final WorkbenchMenuItem item = new WorkbenchMenuItem( caption,
                                                                  new Command() {

                                                                      @Override
                                                                      public void execute() {
                                                                          Window.alert( "You clicked " + caption );
                                                                      }

                                                                  } );
            item.setHasPermission( i < 3 );
            subMenuBar2.addItem( item );
        }

        //Sub-menu#3 - Disabled
        final WorkbenchMenuBar subMenuBar3 = new WorkbenchMenuBar( true );
        final WorkbenchMenuItem subMenuBar3Item = new WorkbenchMenuItem( "TestPresenter menu-3",
                                                                         subMenuBar3 );
        subMenuBar3Item.setHasPermission( false );
        menuBar.addItem( subMenuBar3Item );

        return menuBar;
    }

}