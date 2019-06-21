package hr.ferit.brunozoric.taskie.di

import hr.ferit.brunozoric.taskie.presentation.AddTaskDialogDialogPresenter
import hr.ferit.brunozoric.taskie.presentation.LoginPresenter
import hr.ferit.brunozoric.taskie.presentation.RegisterPresenter
import hr.ferit.brunozoric.taskie.presentation.TasksFragmentPresenter
import hr.ferit.brunozoric.taskie.ui.login.LoginContract
import hr.ferit.brunozoric.taskie.ui.register.RegisterContract
import hr.ferit.brunozoric.taskie.ui.tasklist.fragment.AddTaskDilogContract
import hr.ferit.brunozoric.taskie.ui.tasklist.fragment.TasksFragmentContract
import org.koin.dsl.module


val presentationModule = module {
    factory<LoginContract.Presenter> { LoginPresenter(get()) }
    factory<RegisterContract.Presenter> { RegisterPresenter(get()) }
    factory<TasksFragmentContract.Presenter>{ TasksFragmentPresenter(get()) }
    factory<AddTaskDilogContract.Presenter>{ AddTaskDialogDialogPresenter(get()) }
}